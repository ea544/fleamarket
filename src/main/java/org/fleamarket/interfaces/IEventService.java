package org.fleamarket.interfaces;

import java.util.List;

import org.fleamarket.domain.Event;
import org.fleamarket.vendor.model.Vendor;

public interface IEventService {

	public List<Event> getEvents();

	public void createEvent(Event event);

	public void deleteEvent(int id);

	public void editEvent(Event event);

	public Event getEventById(int id);

	public void addVendor(Integer id, Integer idVendor);

	public void deleteVendor(Integer id, Integer idVendor);

	public Vendor getVendorById(Integer id);

	public List<Vendor> getVendors();

	public List<Vendor> getVendorsByEventId(Integer id);
}
