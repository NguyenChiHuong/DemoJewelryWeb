package com.webbanhang.dto;

import org.springframework.web.multipart.MultipartFile;

import com.webbanhang.entity.CategoryEntity;
import com.webbanhang.entity.ColorEntity;

public class ProductDTO extends BaseDTO<ProductDTO>{

	private String size;
	

	private String name;
	

	private Double price;
	

	private int sale;
	

	private String title;
	

	private boolean highlight;
	

	private boolean newProduct;
	

	private String detail;
	
	private String img;
	
	private MultipartFile file;
	
	private String imageUrl;
	
	private String colorCode;
	
	private String colorName;
	
	private String categoryCode;
	
	private CategoryEntity category;
	
	private ColorEntity color;
	
	public ProductDTO() {}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public ColorEntity getColor() {
		return color;
	}

	public void setColor(ColorEntity color) {
		this.color = color;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public ProductDTO(String size, String name, Double price, int sale, String title, boolean highlight,
			boolean newProduct, String detail, String img, String colorCode, String colorName, String categoryCode) {
		super();
		this.size = size;
		this.name = name;
		this.price = price;
		this.sale = sale;
		this.title = title;
		this.highlight = highlight;
		this.newProduct = newProduct;
		this.detail = detail;
		this.img = img;
		this.colorCode = colorCode;
		this.colorName = colorName;
		this.categoryCode = categoryCode;
	}

	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isHighlight() {
		return highlight;
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}

	public boolean isNewProduct() {
		return newProduct;
	}

	public void setNewProduct(boolean newProduct) {
		this.newProduct = newProduct;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

}
