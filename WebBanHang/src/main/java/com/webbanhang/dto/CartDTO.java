package com.webbanhang.dto;

public class CartDTO extends BaseDTO<CartDTO>{
	private int quanTy;
	private double totalPrice;
	private ProductDTO product;
	
	
	public CartDTO(){}
	
	public CartDTO(int quanTy, double totalPrice, ProductDTO product) {
		super();
		this.quanTy = quanTy;
		this.totalPrice = totalPrice;
		this.product = product;
	}

	public int getQuanTy() {
		return quanTy;
	}

	public void setQuanTy(int quanTy) {
		this.quanTy = quanTy;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	
	
}
