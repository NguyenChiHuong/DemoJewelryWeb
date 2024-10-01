package com.webbanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webbanhang.entity.ColorEntity;

@Repository
public interface ColorRepository extends JpaRepository<ColorEntity, Integer>{
	ColorEntity findOneByCode(String code);
}
