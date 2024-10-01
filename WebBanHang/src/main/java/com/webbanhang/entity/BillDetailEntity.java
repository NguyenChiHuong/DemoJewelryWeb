package com.webbanhang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BillDetail")
public class BillDetailEntity extends BaseEntity{
	
	@Column
	private int quanTy;
	
	@Column
	private double total;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_product")
	private ProductEntity product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_bills")
	private BillEntity bill;

	public ProductEntity getProduct() {
		return product;
	}

	public void setProductId(int productId) {
	    this.product = new ProductEntity();
	    this.product.setId(productId);
	}

	public void setBillId(int billId) {
	    this.bill = new BillEntity();
	    this.bill.setId(billId);
	}

	public BillEntity getBill() {
		return bill;
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
