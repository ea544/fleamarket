package org.fleamarket.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.fleamarket.product.model.Product;

@Entity
public class Review {
	@Id
	@GeneratedValue
	int id;
	String details;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="product_id")
	private Product product;
	
	public Review() {
	}
	/*public Review(String details) {
		this.details = details;
	}*/
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
	
}
