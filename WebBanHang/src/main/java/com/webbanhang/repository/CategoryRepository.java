package com.webbanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webbanhang.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{
	
//	@Query("SELECT p, c FROM ProductEntity p JOIN p.colors c WHERE p.category.id = :categoryId")
//	public List<Object[]> findByCategoryId(@Param("categoryId") int categoryId, Pageable pageable);
//	
//	@Query("SELECT p, c FROM ProductEntity p JOIN p.colors c WHERE p.category.id = :categoryId")
//	public List<Object[]> findByCategoryId(@Param("categoryId") int categoryId);
	
	CategoryEntity findOneByCode(int id);
	CategoryEntity findOneByCode(String id);
}
