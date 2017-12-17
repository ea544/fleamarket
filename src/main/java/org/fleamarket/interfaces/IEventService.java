package org.fleamarket.interfaces;

import java.sql.Date;
import java.util.List;

import org.fleamarket.domain.Address;
import org.fleamarket.domain.Event;
import org.fleamarket.domain.Vendor;

public interface IEventService {
	
	public abstract void createEvent(String title, String description, double organizingCostEstimate, double subscriptionFee, String review, String organizer,
			Address address);
	
	public abstract void deleteEvent(Event event);
	
	public abstract void editEvent(Event event);
	
	public abstract void comment(String comments);
	
	public abstract void addVendor(Vendor vendor);
	
	public abstract List<Vendor> vendorsList();
	
	public abstract Event searchEvent(String filter);

}
