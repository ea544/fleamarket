package org.fleamarket.event.dao;

import java.util.List;

import org.fleamarket.event.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("eventRepository")

public interface EventRepository extends JpaRepository<Event, Integer> {

	//@Query("FROM Event v LEFT JOIN FETCH v.vendors")
	//List<Event> getEventsWithVendors();
}
