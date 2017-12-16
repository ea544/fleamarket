package org.fleamarket.service;

import java.sql.Date;
import java.util.List;

import org.fleamarket.domain.Event;
import org.fleamarket.domain.Vendor;
import org.fleamarket.interfaces.IEventService;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class EventService implements IEventService {

	private SessionFactory sessionFactory;

	public EventService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void createEvent(Date date, double organizingCostEstimate, double subscriptionFee) {
		Event event = new Event(date, organizingCostEstimate, subscriptionFee);
		sessionFactory.getCurrentSession().persist(event);
	}

	public void updateEvent(Event event) {

	}

	public void deleteEvent(Event event) {

	}

	public void editEvent(Event event) {

	}

	public void comment(String comments) {

	}

	public void addVendor(Vendor vendor) {

	}

	public List<Vendor> vendorsList() {
		return null;

	}

	public Event searchEvent(String filter) {
		return null;
	}

}