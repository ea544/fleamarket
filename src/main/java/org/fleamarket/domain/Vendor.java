package org.fleamarket.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vendor {
	@Id
	@GeneratedValue
	public Integer id;

	private String firstname;
	private String lastname;
	private String email;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Integer getId() {
		return id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals(Object vendor) {
		
		if(vendor instanceof Vendor == false)
			return false;
		
		Vendor v = (Vendor)vendor;
		
		return v.id == this.id;
		
	}

}
