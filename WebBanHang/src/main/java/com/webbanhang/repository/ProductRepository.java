package com.webbanhang.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webbanhang.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

//	@Query("SELECT p, c FROM ProductEntity p JOIN p.colors c")
//	public List<Object[]> findAllProductsWithColors();
//	
//	@Query("SELECT p, c FROM ProductEntity p JOIN p.colors c")
//	public List<Object[]> findAllProduct(Pageable pageable);
//	
//	@Query("SELECT p, c FROM ProductEntity p JOIN p.colors c WHERE p.id = :id")
//	public List<Object[]> findOne(@Param("id") int id);

	//@Query("SELECT p, c FROM ProductEntity p JOIN p.colors c WHERE p.highlight = true GROUP BY p, c ORDER BY random() LIMIT 9 ")
	//public List<Object[]> findHighlight(@Param("highlightLimit") int highlightLimit);
		/*
		 * @Query("SELECT p, c FROM ProductEntity p JOIN p.colors c WHERE p.new_product = true GROUP BY p, c ORDER BY FUNCTION('RAND') LIMIT 9"
		 * ) public List<ProductEntity> findNewProducts(@Param("newProductLimit") int
		 * newProductLimit);
		 */
	List<ProductEntity> findAllByCategoryId(int id,Pageable pageable);
	List<ProductEntity> findAllById(int id);
	List<ProductEntity> findAllByCategoryId(int id);
	//ProductEntity findById(int id);
}
