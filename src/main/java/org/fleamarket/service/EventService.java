package org.fleamarket.service;

import java.util.List;

import org.fleamarket.domain.Event;
import org.fleamarket.domain.Vendor;
import org.fleamarket.interfaces.IEventService;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class EventService implements IEventService {

	@Autowired
	private SessionFactory sessionFactory;

	public EventService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Event> getEvents() {
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
		if (event != null) {
			sessionFactory.getCurrentSession().delete(event);
		}
	}

	@Transactional
	public void editEvent(Event event) {
		sessionFactory.getCurrentSession().update(event);
	}

	@Transactional
	public Event getEventById(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Event p WHERE p.eventId = :id");
		query.setParameter("id", id);
		Event event = (Event) query.getSingleResult();
		return event;
	}
	
	//vendors

	@Transactional
	public void addVendor(Integer idEvent, Integer idVendor) {	
		Event event = getEventById(idEvent);
		event.addVendor(getVendorById(idVendor));
		sessionFactory.getCurrentSession().update(event);
	}

	@Transactional
	public Vendor getVendorById(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Vendor p WHERE p.id = :id");
		query.setParameter("id", id);
		Vendor vendor = (Vendor) query.getSingleResult();
		return vendor;
	}

	@Transactional
	public List<Vendor> getVendors() {
		Query<Vendor> query = sessionFactory.getCurrentSession().createQuery("from Vendor", Vendor.class);
		return query.list();
	}

	@Transactional
	public List<Vendor> getVendorsByEventId(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Event p WHERE p.eventId = :id");
		query.setParameter("id", id);
		Event event = (Event) query.getSingleResult();
		return event.getVendors();
	}

	@Transactional
	public void deleteVendor(Integer id, Integer idVendor) {
		Event event = getEventById(id);
		event.getVendors().remove(getVendorById(idVendor));
		sessionFactory.getCurrentSession().update(event);
	}
	
	//organizers

	@Transactional
	public void addOrganizer(Integer idEvent, Integer idVendor) {		
		Event event = getEventById(idEvent);
		sessionFactory.getCurrentSession().update(event);
	}
	

	@Transactional
	public Vendor getOrganizerById(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Vendor p WHERE p.id = :id");
		query.setParameter("id", id);
		Vendor vendor = (Vendor) query.getSingleResult();
		return vendor;
	}

	@Transactional
	public Vendor getOrganizer() {
		Query<Vendor> query = sessionFactory.getCurrentSession().createQuery("from Vendor", Vendor.class);
		return (Vendor) query;
	}

	/*@Transactional
	public List<Vendor> getOrganizersByEventId(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Event p WHERE p.eventId = :id");
		query.setParameter("id", id);
		Event event = (Event) query.getSingleResult();
		return event.getVendors();
	}

	@Transactional
	public void deleteOrganizer(Integer id, Integer idVendor) {
		Event event = getEventById(id);
		event.getVendors().remove(getVendorById(idVendor));
		sessionFactory.getCurrentSession().update(event);
	}*/
	

}
