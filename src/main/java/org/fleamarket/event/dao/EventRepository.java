package org.fleamarket.event.dao;

import java.util.List;

import org.fleamarket.event.model.Event;
import org.fleamarket.vendor.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer>{
	
	//List<Event> findAllEvents();
	
	List<Event> findEventById(int eventId);
	
	/*
	 * maybe you don't need this because it doesn't define get* methods List<Event>
	 * getEventById(Integer id);
	 * 
	 * List<Vendor> getVendorById(Integer id);
	 */

	List<Vendor> findAllVendors();
	
	List<Vendor> getVendorsByEventId(Integer id);
	

}
