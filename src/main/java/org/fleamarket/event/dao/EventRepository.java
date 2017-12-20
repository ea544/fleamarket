package org.fleamarket.event.dao;

import org.fleamarket.event.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("eventRepository")

public interface EventRepository extends JpaRepository<Event, Integer> {

}
