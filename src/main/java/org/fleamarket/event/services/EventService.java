package org.fleamarket.event.services;

import java.util.List;

import org.fleamarket.event.dao.EventRepository;
import org.fleamarket.event.model.Event;
import org.fleamarket.vendor.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("eventService")
public class EventService implements IEventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public List<Event> getEvents() {

		// List<Event> query = eventRepository.findAll();
		List<Event> query = eventRepository.getEventsWithVendors();
		return query;
	}

	@Override
	public void createEvent(Event event) {

		eventRepository.save(event);
	}

	@Override

	public void editEvent(Event event) {

		eventRepository.save(event);
	}

	@Override

	public void deleteEvent(int id) {
		Event event = getEventById(id);

		eventRepository.delete(event);
	}
	
	@Override

	public Event getEventById(int id) {

		return eventRepository.findById(id).get();
	}

	@Override
	public void updateEvent(Event event) {

		eventRepository.save(event);

	}

	/**
	 * Return a list of events a vendor can subscribe These should be past events
	 * and those he has not subscribed to
	 */
	@Override
	public List<Event> getAvailableEvents(Vendor vendor) {
		return eventRepository.getAvailableEvents(vendor);
	}

}
