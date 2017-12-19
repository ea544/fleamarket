package org.fleamarket.product.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Integer id;
	private String productName;
	private String description;
	private String quantity;
	private String price;
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> photos = new ArrayList<String>();
	
	public Product() {}
	
	public Product(String productName, String description, 
			String quantity, String price) {
		this.productName = productName;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}
	
	
	
	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

	public void addPhoto(String file) {
		photos.add(file);
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s", productName, quantity);
	}

}
