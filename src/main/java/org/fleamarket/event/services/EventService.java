package org.fleamarket.event.services;

import java.util.List;

import org.fleamarket.domain.Vendor;
import org.fleamarket.event.dao.EventRepository;
import org.fleamarket.event.model.Event;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class EventService implements IEventService {

	@Autowired
	//private SessionFactory sessionFactory;
	private EventRepository eventRepository;

	/*public EventService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

	@Transactional
	public List<Event> getEvents() {
		//Query<Event> query = sessionFactory.getCurrentSession().createQuery("from Event", Event.class);
		List<Event> query = eventRepository.findAll();
		return query;
	}

	@Transactional
	public void createEvent(Event event) {
		//essionFactory.getCurrentSession().persist(event);
		eventRepository.save(event);
	}

	@Transactional
	public void deleteEvent(int id) {
		Event event = getEventById(id);
		if (event != null) {
			//sessionFactory.getCurrentSession().delete(event);
			eventRepository.delete(event);
		}
	}

	@Transactional
	public void editEvent(Event event) {
		//sessionFactory.getCurrentSession().update(event);
		eventRepository.save(event);
	}

	@Transactional
	public Event getEventById(int id) {
		//Query query = sessionFactory.getCurrentSession().createQuery("FROM Event p WHERE p.eventId = :id");
		List<Event> event = eventRepository.findEventById(id);
		
		//query.setParameter("id", id);
		//Event event = (Event) query.getSingleResult();
		//return event;
		return (Event) event;
	}
	
	//vendors

	/*@Transactional
	public void addVendor(Integer idEvent, Integer idVendor) {	
		Event event = getEventById(idEvent);
		event.addVendor(getVendorById(idVendor));
		//sessionFactory.getCurrentSession().update(event);

		eventRepository.save(event);
	}

	@Transactional
	public Vendor getVendorById(Integer id) {
		//Query query = sessionFactory.getCurrentSession().createQuery("FROM Vendor p WHERE p.id = :id");
		List<Vendor> vendor =  eventRepository.getVendorById(id);
		
		//query.setParameter("id", id);
		
		//Vendor vendor = (Vendor) query.getSingleResult();
		return (Vendor) vendor;
	}

	@Transactional
	public List<Vendor> getVendors() {
		//Query<Vendor> query = sessionFactory.getCurrentSession().createQuery("from Vendor", Vendor.class);
		List<Vendor> query = eventRepository.findAllVendors();
		return query;
	}

	@Transactional
	public List<Vendor> getVendorsByEventId(Integer id) {
		//Query query = sessionFactory.getCurrentSession().createQuery("FROM Event p WHERE p.eventId = :id");
		List<Vendor> event = eventRepository.getVendorById(id);
		//query.setParameter("id", id);
		//Event event = (Event) query.getSingleResult();
		//return event.getVendors();
		return event;
	}

	@Transactional
	public void deleteVendor(Integer id, Integer idVendor) {
		//Event event = getEventById(id);
		List<Event> event = eventRepository.getEventById(id);
		List<Vendor> vendors = eventRepository.findAllVendors();
		//event.getVendors().remove(getVendorById(idVendor));
		//sessionFactory.getCurrentSession().update(event);
		eventRepository.getVendorsByEventId(id);
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
