package com.webbanhang.dto;

public class BillDTO extends BaseDTO<BillDTO>{
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String note;
	private int quanTy;
	private double total;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
