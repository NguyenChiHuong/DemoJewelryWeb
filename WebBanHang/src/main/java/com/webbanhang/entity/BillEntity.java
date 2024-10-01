package com.webbanhang.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Bill")
public class BillEntity extends BaseEntity{
	@Column
	private String name;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column
	private String email;
	
	@Column(columnDefinition = "TEXT")
	private String address;
	
	@Column(columnDefinition = "TEXT")
	private String note;
	
	@Column
	private int quanTy;
	
	@Column
	private double total;
	
	@OneToMany(mappedBy = "bill")
	private List<BillDetailEntity> billdetail = new ArrayList<BillDetailEntity>();
	
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
