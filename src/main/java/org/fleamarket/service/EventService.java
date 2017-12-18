package org.fleamarket.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.fleamarket.domain.Address;
import org.fleamarket.domain.Event;
import org.fleamarket.domain.Vendor;
import org.fleamarket.interfaces.IEventService;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class EventService implements IEventService{
	
	@Autowired
	private SessionFactory sessionFactory;

	public EventService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Transactional
	public List<Event> getEvents(){
		Query<Event> query = sessionFactory.getCurrentSession().createQuery("from Event", Event.class);
		return query.list();
	}
	
	

	@Transactional
	public void createEvent(Event event) {
		sessionFactory.getCurrentSession().persist(event);
	}
	
	@Transactional
	public void deleteEvent(int id) {
		Event event = getEventById(id);
		if(event != null) {
			sessionFactory.getCurrentSession().delete(event);
		}
	}
	
	@Transactional
	public void editEvent(Event event) {
		sessionFactory.getCurrentSession().update(event);
	}

	public void comment(String comments) {

	}

	@Transactional
	public Event getEventById(int id) {
		
		System.out.println("Id in service " + id);
	
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Event p WHERE p.eventId = :id");
		query.setParameter("id", id);
		Event event = (Event)query.getSingleResult();
		return event;
	}
///////// vendors
	
	
	@Transactional
	public void addVendor(Integer id) {
		Vendor vendor = getVendorById(id);
		sessionFactory.getCurrentSession().persist(vendor);

	}
	
	@Transactional
	public Vendor getVendorById(Integer id) {
		
		System.out.println("IdVendor in service " + id);
	
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Vendor p WHERE p.id = :id");
		query.setParameter("id", id);
		Vendor vendor = (Vendor)query.getSingleResult();
		return vendor;
	}
	

	@Transactional
	public List<Vendor> getVendors(){
		Query<Vendor> query = sessionFactory.getCurrentSession().createQuery("from Vendor", Vendor.class);
		return query.list();
	}


}
