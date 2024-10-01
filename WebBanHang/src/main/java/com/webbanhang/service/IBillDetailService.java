package com.webbanhang.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.webbanhang.dto.BillDTO;
import com.webbanhang.dto.CartDTO;
import com.webbanhang.entity.BillEntity;

@Service
public interface IBillDetailService {
	public BillEntity addBill(BillDTO bill);
	public void addBillDetail(HashMap<Integer, CartDTO> carts);
}
