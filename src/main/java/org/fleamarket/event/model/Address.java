package org.fleamarket.event.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

@Embeddable
public class Address {

	@NotEmpty // (message = "*Please provide a street of the event")
	private String street;
	@NotEmpty // (message = "*Please provide a city of the event")
	private String city;
	@NotEmpty // (message = "*Please provide a state of the event")
	private String state;
	@Range(min = 10000, max = 99999) // , message = "*Please provide a zip code of the event")
	private int zip;
	private String country;

	public Address() {
		super();
	}

	public Address(String street) {
		super();
		this.street = street;

	}

	public Address(String street, String city, String state, int zip, String country) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + ", country="
				+ country + "]";
	}

}
