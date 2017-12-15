package interfaces;

import java.util.List;

import org.fleamarket.domain.Event;
import org.fleamarket.domain.Vendor;

public interface IEvent {
	
	public abstract Event createEvent();
	
	public abstract void updateEvent(Event event);
	
	public abstract void deleteEvent(Event event);
	
	public abstract void editEvent(Event event);
	
	public abstract void comment(String comments);
	
	public abstract void addVendor(Vendor vendor);
	
	public abstract List<Vendor> vendorsList();
	
	public abstract Event searchEvent(String filter);

}
