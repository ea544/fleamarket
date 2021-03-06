package org.fleamarket.event.controller;

import java.util.List;

import org.fleamarket.event.model.Event;
import org.fleamarket.event.services.IEventService;
import org.fleamarket.vendor.model.Vendor;
import org.fleamarket.vendor.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventController {

	@Autowired
	IEventService eventService;

	@Autowired
	VendorService vendorService;

	public EventController(IEventService eventService, VendorService vendorService) {
		this.eventService = eventService;
		this.vendorService = vendorService;
	}

	// Show all events
	@RequestMapping(value = "/event/eventList", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("events", eventService.getEvents());
		return "event";

	}

	// save event
	@RequestMapping(value = "/event/eventForm", method = RequestMethod.POST)
	public String createEvent(/* @ModelAttribute("event") */ Event event, ModelMap model, BindingResult result) {

		if (result.hasErrors()) {
			return "event";
		}

		if (event.getEventId() == 0) {
			eventService.createEvent(event);
		} else {
			eventService.editEvent(event);
			// update
		}
		model.addAttribute("events", eventService.getEvents());
		return "event";
	}

	// Event form
	@RequestMapping(value = "/event/eventForm", method = RequestMethod.GET)
	public String eventForm(ModelMap model) {
		Event event = new Event();
		model.addAttribute("organizers", vendorService.findAll());
		model.addAttribute("event", event);
		model.addAttribute("edit", false);
		return "eventForm";
	}

	// Edit event
	@RequestMapping(value = "/event/getForm/{id}", method = RequestMethod.GET)
	public String editEvent(@PathVariable("id") int id, Model model) {
		
		Event event = eventService.getEventById(id);
		
		System.out.println(event);
		model.addAttribute("event", event);
		
		model.addAttribute("organizers", vendorService.findAll());
		return "eventForm";
	}

	// delete event
	@RequestMapping(value = "/event/deleteEvent/{id}", method = RequestMethod.GET)
	public String deleteEvent(@PathVariable("id") int id, Model model) {
		eventService.deleteEvent(id);
		model.addAttribute("events", eventService.getEvents());
		return "event";
	}

	// show vendors of the event

	@RequestMapping(value = "/event/vendorList", method = RequestMethod.GET)
	public String getAllVendors(Model model) {
		model.addAttribute("vendors", vendorService.findAll());
		return "eventVendors";

	}

	// add vendor
	@RequestMapping(value = "/event/eventAddVendor/{id}", method = RequestMethod.GET)
	public String addVendor(@PathVariable("id") int id, ModelMap model) {

		Event e = eventService.getEventById(id);
		List<Vendor> selected = e.getVendors();
		List<Vendor> vendorList = vendorService.findAll();
		vendorList.removeAll(selected);
		model.addAttribute("vendors", vendorList);
		model.addAttribute("selectedVendors", selected);
		model.addAttribute("eventId", id);
		return "eventVendors";
	}

	@RequestMapping(value = "/event/eventAddVendor/{eventId}/{vendordId}", method = RequestMethod.GET)
	public String addVendor(@PathVariable("eventId") int eventId, @PathVariable("vendordId") int vendorId,
			ModelMap model) {

		System.out.println("event Id : " + eventId);
		System.out.println("vendor Id : " + vendorId);

		Event event = eventService.getEventById(eventId);

		event.addVendor(vendorService.findVendorById(vendorId).get());

		eventService.updateEvent(event);

		Event e = eventService.getEventById(eventId);
		List<Vendor> selected = e.getVendors();
		List<Vendor> vendorList = vendorService.findAll();

		vendorList.removeAll(selected);
		model.addAttribute("vendors", vendorList);
		model.addAttribute("selectedVendors", selected);
		model.addAttribute("eventId", eventId);

		return "eventVendors";
	}

	@RequestMapping(value = "/event/eventDeleteVendor/{eventId}/{vendordId}", method = RequestMethod.GET)
	public String deleteVendor(@PathVariable("eventId") int eventId, @PathVariable("vendordId") int vendorId,
			ModelMap model) {

		System.out.println("event Id : " + eventId);
		System.out.println("vendor Id : " + vendorId);

		Event event = eventService.getEventById(eventId);

		event.getVendors().remove(vendorService.findVendorById(vendorId).get());

		eventService.updateEvent(event);

		Event e = eventService.getEventById(eventId);
		List<Vendor> selected = e.getVendors();
		List<Vendor> vendorList = vendorService.findAll();

		vendorList.removeAll(selected);
		model.addAttribute("vendors", vendorList);
		model.addAttribute("selectedVendors", selected);
		model.addAttribute("eventId", eventId);

		return "eventVendors";
	}

	/// Organizers
	@RequestMapping(value = "/event/eventAddOrganizer/{id}", method = RequestMethod.GET)
	public String getAllOrganizers(@PathVariable("id") int id, Model model) {
		model.addAttribute("vendors", vendorService.findAll());
		return "eventVendors";

	}

}
