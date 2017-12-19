package org.fleamarket.event.services;

import java.util.List;

import org.fleamarket.event.model.Event;
import org.fleamarket.vendor.model.Vendor;
public interface IEventService {

	public List<Event> getEvents();

	public void createEvent(Event event);

	public void deleteEvent(int id);

	public void editEvent(Event event);

	public List<Vendor> getVendorsByEventId(int id);

	public List<Vendor> getVendors();

	public void addVendor(int eventId, int vendorId);

	public void deleteVendor(int eventId, int vendorId);

	public Object getEventById(int id);

	/*public Event getEventById(int id);

	public void addVendor(Integer id, Integer idVendor);
	
	public Vendor getVendorById(Integer id);
	
	public List<Vendor> getVendors();
	
	public List<Vendor> getVendorsByEventId(Integer id);

	public void deleteVendor(Integer id, Integer idVendor);	
	
	public Vendor getOrganizerById(Integer id);
	
	public Vendor getOrganizer();*/
	
	
}
