package org.fleamarket.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.fleamarket.event.model.Address;
import org.fleamarket.user.model.User;
import org.hibernate.validator.constraints.Length;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int id;
	@NotEmpty(message = "*Please provide a name")
	private String name;
	@Email(message = "*Email can't be blank, please provide a valid email address")
	@NotEmpty(message = "*Please provide a email address")
	private String email;
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@Transient
	private String password;
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Review> reviews;

	
	public Customer() {	
		reviews = new ArrayList<Review>();
	}
	
	public Customer(int id, String name, String email, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		reviews = new ArrayList<Review>();
		
	}	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReviews(Review review) {
		this.reviews.add(review);
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
