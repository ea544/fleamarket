package org.fleamarket.product.dao;

import org.fleamarket.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("FROM Product p LEFT JOIN FETCH p.photos where p.id = :id")
	Product getProductWithPhotos(@Param("id") Integer id);
}
