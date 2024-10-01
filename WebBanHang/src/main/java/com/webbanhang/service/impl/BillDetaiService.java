package com.webbanhang.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbanhang.converter.BillDetailConverter;
import com.webbanhang.dto.BillDTO;
import com.webbanhang.dto.BillDetailDTO;
import com.webbanhang.dto.CartDTO;
import com.webbanhang.entity.BillDetailEntity;
import com.webbanhang.entity.BillEntity;
import com.webbanhang.repository.BillDetailRepository;
import com.webbanhang.repository.BillRepository;
import com.webbanhang.service.IBillDetailService;

@Service
public class BillDetaiService implements IBillDetailService {

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private BillDetailConverter billDetailConverter;

	@Autowired
	private BillDetailRepository billDetailRepository;

	@Override
	public BillEntity addBill(BillDTO bill) {
		BillEntity entity = billDetailConverter.tooEntity(bill);
		return billRepository.save(entity);
	}

	@Override
	public void addBillDetail(HashMap<Integer, CartDTO> carts) {
		int lastBillId = billRepository.findMaxId();

		for (Map.Entry<Integer, CartDTO> itemCart : carts.entrySet()) {
			BillDetailDTO billDetail = new BillDetailDTO();
			billDetail.setId_product(itemCart.getValue().getProduct().getId());
			billDetail.setId_bill(lastBillId);
			billDetail.setQuanTy(itemCart.getValue().getQuanTy());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			BillDetailEntity entity = billDetailConverter.toEntity(billDetail);
			billDetailRepository.save(entity);
		}
	}

}
