package com.webbanhang.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbanhang.dto.CartDTO;
import com.webbanhang.dto.ProductDTO;
import com.webbanhang.service.ICartService;
import com.webbanhang.service.IProductService;

@Service
public class CartService implements ICartService{
	
	@Autowired
	private IProductService productService;
	
	@Override
	public HashMap<Integer, CartDTO> addCart(int id, HashMap<Integer, CartDTO> cart) {
		CartDTO dto = new CartDTO();
		
		//Lấy sản phẩm theo id
		ProductDTO product = productService.findProductById(id);
		//ProductDTO productDTO = productConverter.toDto(product);
		if (product != null && cart.containsKey(id) /*cart có chứa id sản phẩm */ ) {
			dto = cart.get(id); /* dto nhận id từ cart */
			dto.setQuanTy(dto.getQuanTy() + 1); /*có chứa sản phẩm đã có thì tăng lên 1*/
			dto.setTotalPrice(dto.getQuanTy() * dto.getProduct().getPrice()); /* tổng giá của sản phẩm */
		} else { /* Trường hợp null */
			dto.setProduct(product); /* Thêm mới sản phẩm */
			dto.setQuanTy(1); 
			dto.setTotalPrice(product.getPrice());
		}
		cart.put(id, dto); /* giỏ hàng nhận giá trị sản phẩm */
		return cart;
	}

	@Override
	public HashMap<Integer, CartDTO>  editCart(int id, int quanTy, HashMap<Integer, CartDTO> cart) {
		CartDTO dto = new CartDTO();
		/* Trường hợp cart chưa có gì thì trả về ban đầu */
		if(cart == null) {
			return cart;
		}
		if(cart.containsKey(id) /*cart có chứa id sản phẩm */) {
			dto = cart.get(id);
			dto.setQuanTy(quanTy);
			/* Tính số lượng từng sản phẩm */
			Double total = quanTy * dto.getProduct().getPrice();
			dto.setTotalPrice(total);
		}
		cart.put(id, dto);/* giỏ hàng nhận giá trị sản phẩm */
		return cart;
	}

	@Override
	public HashMap<Integer, CartDTO>  deleteCart(int id, HashMap<Integer, CartDTO> cart) {
		/* Trường hợp cart chưa có gì thì trả về ban đầu */
		if(cart == null) { 
			return cart;
		}
		if(cart.containsKey(id)) {/*cart có chứa id sản phẩm */
			cart.remove(id); /* xóa sản phẩm trong giỏ hang */
		}
		return cart;
	}

	@Override
	public int totalQuanTy(HashMap<Integer, CartDTO> cart) {
		
		int totalquanty = 0;
		/* Duyệt qua từng (entrySet: giá trị trong cart) lưu vào item */
		for (Map.Entry<Integer, CartDTO> item : cart.entrySet()) {
			/* Tính tổng số lượng sản phẩm */
			totalquanty += item.getValue().getQuanTy();
		}
		return totalquanty;
	}

	@Override
	public double totalPrice(HashMap<Integer, CartDTO> cart) {
		int totalprice = 0;
		/* Duyệt qua từng (entrySet: giá trị trong cart) lưu vào item */
		for (Map.Entry<Integer, CartDTO> item : cart.entrySet()) {
			/* Tính tổng giá sản phẩm */
			totalprice += item.getValue().getTotalPrice();
		}
		return totalprice;
	}

}
