package com.webbanhang.Controller.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.webbanhang.dto.ProductDTO;
import com.webbanhang.entity.CategoryEntity;
import com.webbanhang.entity.ColorEntity;
import com.webbanhang.repository.CategoryRepository;
import com.webbanhang.repository.ColorRepository;
import com.webbanhang.service.ICategoryService;
import com.webbanhang.service.IProductService;
import com.webbanhang.util.MessageUtil;

@Controller(value = "newControllerOfAdmin")
public class NewController {

	@Autowired
	private IProductService productService;

	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private ColorRepository colorRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private MessageUtil messageUtil;
	
	@Autowired
	private Cloudinary cloudinary;

	@RequestMapping(value = "/quan-tri/san-pham/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/new/list");
		ProductDTO model = new ProductDTO();
		model.setPage(page);
		model.setLimit(limit);
		Pageable pageable = new PageRequest(page - 1, limit);// từ vị trí thứ 0,giới hạn =2
		model.setListResult(productService.findallproduct(pageable));// findAll dựa trên phân trang
		model.setTotalItem(productService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));// tổng page = tổng số
																								// item / 2
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/quan-tri/san-pham/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Integer id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/new/edit");
		ProductDTO model = new ProductDTO();
		if (id != null) { // khi cập nhật
			model = productService.findProductById(id);// find 1 phần tử lên client
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("categories", categoryService.GetDataCategory());
		mav.addObject("colors", colorRepository.findAll());
		mav.addObject("model", model);
		return mav;
	}
	
	@PostMapping("/quan-tri/san-pham/chinh-sua")
    public String add(@ModelAttribute(value = "model") ProductDTO productDTO) {
        try {
            // Upload file to Cloudinary
            String imageUrl = uploadFileToCloudinary(productDTO.getFile());
            if (imageUrl != null) {
                productDTO.setImageUrl(imageUrl);
            }

            // Map categoryCode and colorCode to CategoryEntity and ColorEntity
            CategoryEntity category = categoryRepository.findOneByCode(productDTO.getCategoryCode());
            ColorEntity color = colorRepository.findOneByCode(productDTO.getColorCode());

            // Set the category and color in the ProductDTO or ProductEntity
            productDTO.setCategory(category);
            productDTO.setColor(color);

            // Save the product
            productService.save(productDTO);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
        return "redirect:/quan-tri/san-pham/danh-sach";
    }

    public String uploadFileToCloudinary(MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            return (String) uploadResult.get("url");
        }
        return null;
    }
}
