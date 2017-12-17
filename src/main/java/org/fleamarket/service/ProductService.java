package org.fleamarket.service;

import org.fleamarket.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

public class ProductService {
	private SessionFactory sessionFactory;

	public ProductService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Integer createProduct(Product product) {
		Integer id = (Integer)sessionFactory.getCurrentSession().save(product);
		return id;
	}
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public Product getProduct(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Product p WHERE p.id = :id");
		query.setParameter("id", id);
		Product product = (Product)query.getSingleResult();
		return product;
	}
	
	@Transactional
	public void updateProduct(Product product) {
		sessionFactory.getCurrentSession().update(product);
		return;
	}
}
