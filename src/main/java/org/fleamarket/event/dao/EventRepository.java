package org.fleamarket.event.dao;

import java.util.List;
import java.util.Optional;

import org.fleamarket.event.model.Event;
import org.fleamarket.vendor.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("eventRepository")

public interface EventRepository extends JpaRepository<Event, Integer> {

	@Query("FROM Event v LEFT JOIN FETCH v.vendors")
	List<Event> getEventsWithVendors();

	@Override
	@Query("FROM Event e LEFT JOIN FETCH e.vendors where e.id = :id")
	Optional<Event> findById(@Param("id") Integer id);

	@Query("FROM Event e LEFT JOIN FETCH e.vendors "
			+ "WHERE :vendor NOT MEMBER OF e.vendors")
	// e.date > CURRENT_DATE AND
	List<Event> getAvailableEvents(@Param("vendor") Vendor vendor);
}
