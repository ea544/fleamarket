package org.fleamarket.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.fleamarket.domain.Address;
import org.fleamarket.domain.Event;
import org.fleamarket.domain.Vendor;
import org.fleamarket.interfaces.IEventService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class EventService {
	
	@Autowired
	private SessionFactory sessionFactory;

	public EventService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@SuppressWarnings("unchecked")
	public List<Event> getEvents(){
		return sessionFactory.getCurrentSession().createQuery("from event").list();
	}

	@Transactional
	public void createEvent(Event event) {
		sessionFactory.getCurrentSession().persist(event);
	}
	

	public void deleteEvent(int id) {
		Event event = searchEvent(id);
		if(event != null) {
			sessionFactory.getCurrentSession().delete(event);
		}
	}

	public void editEvent(Event event) {
		sessionFactory.getCurrentSession().update(event);
	}

	public void comment(String comments) {

	}

	public void addVendor(Vendor vendor) {

	}

	public List<Vendor> vendorsList() {
		return null;

	}

	public Event searchEvent(int id) {
		return (Event) sessionFactory.getCurrentSession().createQuery("from event where id = id").setParameter("id", id);
	}



}
