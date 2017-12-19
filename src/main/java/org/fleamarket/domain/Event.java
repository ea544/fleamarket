package org.fleamarket.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.fleamarket.vendor.model.Vendor;

@Entity
public class Event {

	@Id
	@GeneratedValue
	private int eventId;

	private Date date;

	private String title;
	private String description;
	private double organizingCostEstimate;
	private double subscriptionFee;
	private String review;

	@Embedded
	private Address address;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	/*@JoinColumn(name = "id")*/
	private List<Vendor> vendors = new ArrayList<Vendor>();

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "id")
	private Vendor organizer;

	public Event() {
		super();
	}

	public Event(String title, String description, double organizingCostEstimate, double subscriptionFee, String review,
			Vendor organizer, List<Vendor> vendors) {
		super();
		this.title = title;
		this.description = description;
		this.organizingCostEstimate = organizingCostEstimate;
		this.subscriptionFee = subscriptionFee;
		this.review = review;
		this.organizer = organizer;
		this.vendors = vendors;
	}

	public Event(String title, String description, Date date, double organizingCostEstimate, double subscriptionFee,
			String review, Vendor organizer, Address address, List<Vendor> vendors) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
		this.organizingCostEstimate = organizingCostEstimate;
		this.subscriptionFee = subscriptionFee;
		this.review = review;
		this.organizer = organizer;
		this.address = address;
	}
	
	public void addVendor(Vendor vendor) {
		this.vendors.add(vendor);
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public List<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

	public Vendor getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Vendor organizer) {
		this.organizer = organizer;
	}

}
