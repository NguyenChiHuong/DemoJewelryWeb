package com.webbanhang.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.webbanhang.dto.CartDTO;

@Service
public interface ICartService {
	public HashMap<Integer, CartDTO>  addCart(int id,HashMap<Integer, CartDTO> cart );
	public HashMap<Integer, CartDTO>  editCart(int id,int quanTy,HashMap<Integer, CartDTO> cart );
	public HashMap<Integer, CartDTO>  deleteCart(int id,HashMap<Integer, CartDTO> cart );
	public int totalQuanTy(HashMap<Integer, CartDTO> cart );
	public double totalPrice(HashMap<Integer, CartDTO> cart );
}
