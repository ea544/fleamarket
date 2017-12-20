package org.fleamarket.vendor.service;

import java.util.List;
import java.util.Optional;

import org.fleamarket.event.model.Event;
import org.fleamarket.vendor.model.Vendor;

public interface VendorService {

	public Vendor saveVendor(Vendor vendor);

	public Optional<Vendor> findVendorById(Integer id);
	
	public void updateVendor(Vendor vendor);

	public void subscribeToEvent(Vendor vendor, Event event);

	public List<Vendor> findVendorWithEvents(Integer id);

	public List<Vendor> findAll();
}
