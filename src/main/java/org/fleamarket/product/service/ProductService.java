package org.fleamarket.product.service;

import java.util.Optional;

import org.fleamarket.product.model.Product;

public interface ProductService {
	
	public Product saveProduct(Product vendor);

	public Optional<Product> findProductById(Integer id);
	
	public void updateProduct(Product vendor);

	public Product getProduct(Integer id);
}
