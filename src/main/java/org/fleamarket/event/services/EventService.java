package org.fleamarket.event.services;

import java.util.List;

import org.fleamarket.event.dao.EventRepository;
import org.fleamarket.event.model.Event;
import org.fleamarket.vendor.dao.VendorRepository;
import org.fleamarket.vendor.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("eventService")
public class EventService implements IEventService {

	@Autowired
	//private SessionFactory sessionFactory;
	private EventRepository eventRepository;

	@Autowired
	private VendorRepository vendorRepository;
	/*public EventService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

	@Override
	//@Transactional
	public List<Event> getEvents() {
		//Query<Event> query = sessionFactory.getCurrentSession().createQuery("from Event", Event.class);
		List<Event> query = eventRepository.findAll();
		return query;
	}

	@Override
	//@Transactional
	public void createEvent(Event event) {
		//essionFactory.getCurrentSession().persist(event);
		eventRepository.save(event);
	}
	
	@Override
	//@Transactional
	public void editEvent(Event event) {
		//sessionFactory.getCurrentSession().update(event);
		eventRepository.save(event);
	}
	
	

	@Override
	//@Transactional
	public void deleteEvent(int id) {
		Event event = getEventById(id);
		//if (event != null) {
			//sessionFactory.getCurrentSession().delete(event);
			eventRepository.delete(event);
			//eventRepository.removeByEventId(eventRepository.findById(id));
		}
	//}

	@Override
	@Transactional
	public Event getEventById(int id) {
		//Query query = sessionFactory.getCurrentSession().createQuery("FROM Event p WHERE p.eventId = :id");
		//eventRepository.findEventByEventId(id);
		
		//query.setParameter("id", id);
		//Event event = (Event) query.getSingleResult();
		//return event;
		return eventRepository.getEventByEventId(id);
	}
	
	
	//@Transactional
	@Override
	public List<Vendor> getVendorsByEventId(int id) {
		//Query query = sessionFactory.getCurrentSession().createQuery("FROM Event p WHERE p.eventId = :id");
		List<Vendor> vendors = eventRepository.getVendorByEventId(id);
		//query.setParameter("id", id);
		//Event event = (Event) query.getSingleResult();
		//return event.getVendors();
		return vendors;
	}

	
	//vendors
	
	//@Transactional
	public List<Vendor> getEventById() {
		//Query<Vendor> query = sessionFactory.getCurrentSession().createQuery("from Vendor", Vendor.class);
		//List<Vendor> query = vendorRepository.findAll();
		return vendorRepository.findAll(); //query;
	}

	//@Transactional
	public void addVendor(Integer idEvent, Integer idVendor) {	
		Event event = getEventById(idEvent);
		event.addVendor(getVendorById(idVendor));
		//sessionFactory.getCurrentSession().update(event);
		eventRepository.save(event);
	}
	
	
	//@Transactional
	public Vendor getVendorById(Integer id) {
		//Query query = sessionFactory.getCurrentSession().createQuery("FROM Vendor p WHERE p.id = :id");
		//List<Vendor> vendor =  vendorRepository.findVendorById(id);
		
		//query.setParameter("id", id);
		
		//Vendor vendor = (Vendor) query.getSingleResult();
		return (Vendor) vendorRepository.findVendorById(id);
	}
	
	//@Transactional
	public List<Vendor> getVendors() {
		//Query<Vendor> query = sessionFactory.getCurrentSession().createQuery("from Vendor", Vendor.class);
		List<Vendor> query = vendorRepository.findAll();
		return query;
	}



	@Transactional
	public void deleteVendor(int id, Integer idVendor) {
		//Event event = getEventById(id);
		//--------List<Event> event =  eventRepository.getEventByEventId(id);
		//---------List<Vendor> vendors = vendorRepository.findAll();
		//event.getVendors().remove(getVendorById(idVendor));
		//sessionFactory.getCurrentSession().update(event);
		//---------eventRepository.getVendorsByEventId(id);
	}
	
	//organizers

	//@Transactional
	public void addOrganizer(Integer idEvent, Integer idVendor) {		
		Event event = getEventById(idEvent);
		sessionFactory.getCurrentSession().update(event);
	}
	

	//@Transactional
	public Vendor getOrganizerById(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Vendor p WHERE p.id = :id");
		query.setParameter("id", id);
		Vendor vendor = (Vendor) query.getSingleResult();
		return vendor;
	}

	//@Transactional
	public Vendor getOrganizer() {
		Query<Vendor> query = sessionFactory.getCurrentSession().createQuery("from Vendor", Vendor.class);
		return (Vendor) query;
	}

	@Override
	public void addVendor(int eventId, int vendorId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVendor(int eventId, int vendorId) {
		// TODO Auto-generated method stub
		
	}

	

}
