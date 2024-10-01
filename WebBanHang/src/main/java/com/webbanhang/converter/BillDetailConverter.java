package com.webbanhang.converter;

import org.springframework.stereotype.Component;

import com.webbanhang.dto.BillDTO;
import com.webbanhang.dto.BillDetailDTO;
import com.webbanhang.entity.BillDetailEntity;
import com.webbanhang.entity.BillEntity;

@Component
public class BillDetailConverter {
	public BillDetailEntity toEntity(BillDetailDTO bill) {
		BillDetailEntity billDetail = new BillDetailEntity();
		billDetail.setQuanTy(bill.getQuanTy());
		billDetail.setTotal(bill.getTotal());
		billDetail.setProductId(bill.getId_product());
		billDetail.setBillId(bill.getId_bill());
		return billDetail;
	}
	
	public BillEntity tooEntity(BillDTO bill) {
		BillEntity billEntity = new BillEntity();
		billEntity.setQuanTy(bill.getQuanTy());
		billEntity.setTotal(bill.getTotal());
		billEntity.setName(bill.getName());
		billEntity.setPhoneNumber(bill.getPhoneNumber());
		billEntity.setAddress(bill.getAddress());
		billEntity.setEmail(bill.getEmail());
		billEntity.setNote(bill.getNote());
		return billEntity;
	}
}
