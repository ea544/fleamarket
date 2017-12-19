package org.fleamarket.vendor.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.fleamarket.event.model.Event;

@Entity
public class Vendor {
	@Id
	@GeneratedValue
	public Integer id;

	private String firstname;
	private String lastname;
	private String email;

	@OneToMany(mappedBy = "vendors")
	private List<Event> events;

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Vendor() {}
	
	
	
	public Vendor(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}



	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
	
	/*@Override
	public String toString() {
		return firstname + " " + lastname;
	}*/

}
