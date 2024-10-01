package com.webbanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webbanhang.entity.BillEntity;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Integer>{
	@Query(value = "SELECT MAX(b.id) FROM BillEntity b")
    public Integer findMaxId();
}
