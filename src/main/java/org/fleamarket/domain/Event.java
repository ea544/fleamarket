package org.fleamarket.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Event {
	private Date date;
	private String title;
	private String description;
	private double organizingCostEstimate;
	private double subscriptionFee;
	private String review;
	private String organizer;
	//private Address address;
	
	@Id
	@GeneratedValue
	private int eventId;
	
		
	public Event() {
		super();
	}
	
	
	
	public Event(String title, String description, double organizingCostEstimate, double subscriptionFee, String review, String organizer) {
		super();
		this.title = title;
		this.description =  description;
		this.organizingCostEstimate = organizingCostEstimate;
		this.subscriptionFee = subscriptionFee;
		this.review = review;
		this.organizer = organizer;
	}



	public Event(String title, String description, Date date, double organizingCostEstimate, double subscriptionFee, String review, String organizer,
			Address address) {
		super();
		this.title = title;
		this.description =  description;
		this.date = date;
		this.organizingCostEstimate = organizingCostEstimate;
		this.subscriptionFee = subscriptionFee;
		this.review = review;
		this.organizer = organizer;
		//this.address = address;
	}
	
	
	
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getOrganizingCostEstimate() {
		return organizingCostEstimate;
	}
	public void setOrganizingCostEstimate(double organizingCostEstimate) {
		this.organizingCostEstimate = organizingCostEstimate;
	}
	public double getSubscriptionFee() {
		return subscriptionFee;
	}
	public void setSubscriptionFee(double subscriptionFee) {
		this.subscriptionFee = subscriptionFee;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	/*public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}*/
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
}
