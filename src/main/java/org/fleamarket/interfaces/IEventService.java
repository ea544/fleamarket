package org.fleamarket.interfaces;

import java.util.List;

import org.fleamarket.domain.Event;
import org.fleamarket.domain.Vendor;

public interface IEventService {

	public List<Event> getEvents();

	public void createEvent(Event event);

	public void deleteEvent(int id);

	public void editEvent(Event event);

	public Event getEventById(int id);
	
	public void addVendor(Vendor vendor);

	public List<Vendor> getVendors();
}
