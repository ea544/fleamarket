package org.fleamarket.event.dao;

import java.util.List;

import org.fleamarket.event.model.Event;
import org.fleamarket.vendor.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("eventRepository")

public interface EventRepository extends JpaRepository<Event, Integer>{
	
	List<Event> findAll();
	
	List<Event> findEventByEventId(int eventId);
	
	Event getEventByEventId(int eventId);
	
	void removeByEventId(int eventId);
	
	List<Vendor> getVendorByEventId(int eventId);
	
	/*
	 * maybe you don't need this because it doesn't define get* methods List<Event>
	 * getEventById(Integer id);
	 * 
	 * List<Vendor> getVendorById(Integer id);
	 */

	//List<Vendor> findAllVendors();
	
	//List<Vendor> getVendorsByEventId(Integer id);
	

}
