package com.webbanhang.dto;

public class BillDetailDTO {
	private int id_product;
	private int id_bill;
	private int quanTy;
	private double total;

	
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public int getId_bill() {
		return id_bill;
	}
	public void setId_bill(int lastBillId) {
		this.id_bill = lastBillId;
	}
	public int getQuanTy() {
		return quanTy;
	}
	public void setQuanTy(int quanTy) {
		this.quanTy = quanTy;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
