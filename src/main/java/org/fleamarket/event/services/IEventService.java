package org.fleamarket.event.services;

import java.util.List;

import org.fleamarket.event.model.Event;

public interface IEventService {

	public List<Event> getEvents();

	public void createEvent(Event event);

	public void deleteEvent(int id);

	public void editEvent(Event event);

	public Event getEventById(int id);

	public void updateEvent(Event event);

}
