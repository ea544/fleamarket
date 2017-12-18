package org.fleamarket.controller;

import org.fleamarket.domain.Address;
import org.fleamarket.domain.Event;
import org.fleamarket.domain.Vendor;
import org.fleamarket.interfaces.IEventService;
import org.fleamarket.service.EventService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
/*@RequestMapping(value = "/events")*/

public class EventController {
	
	@Autowired
	IEventService eventService;
	
	public EventController(IEventService eventService) {
		this.eventService = eventService;
	}
	
	
	
/*	@RequestMapping(value = { "", "/event" }, method = RequestMethod.GET)
	public String redirectRoot() {
		return "event";
	}*/
	
	//Show all events
	
	@RequestMapping(value="/event/eventList", method=RequestMethod.GET)
	public String getAll(Model model) {
		
		System.out.println("Events List");
		
		model.addAttribute("events", eventService.getEvents());
			
		/*return "redirect:/events";*/
		
		return "event";
		
	}
	
	//save event

	@RequestMapping(value = "/event/eventForm", method = RequestMethod.POST)
	public String createEvent(@ModelAttribute("event") Event event, ModelMap model) {
		
		if(event.getEventId() == 0) {
			
			eventService.createEvent(event);
		} else {
			eventService.editEvent(event);
			//update
		}
		
		
		model.addAttribute("events", eventService.getEvents());
		/*return "redirect:/events";*/
		return "event";
	}
	
	//Event form

	@RequestMapping(value = "/event/eventForm", method = RequestMethod.GET)
	public String eventForm(ModelMap model) {
		Event event = new Event();
		model.addAttribute("event", event);
		model.addAttribute("edit", false);
		return "eventForm";
	}
	
	//Edit event
	
	@RequestMapping(value="/event/getForm/{id}", method=RequestMethod.GET)
	public String editEvent(@PathVariable("id") int id, Model model) {
		
		System.out.println("id : " + id);
		model.addAttribute("event", eventService.getEventById(id));
	//	eventService.editEvent(event);
		return "eventForm";
	}
	
	//Search an event
	
	/*@RequestMapping(value="/eventForm/{id}", method=RequestMethod.POST)
	public String searchEvent(@ModelAttribute("event")Event event, @PathVariable int id) {
		eventService.searchEvent(id);
		return "redirect:/events";
	}	*/
	
	//delete event
	
	@RequestMapping(value="/event/deleteEvent/{id}", method=RequestMethod.GET)
	public String deleteEvent(@PathVariable("id") int id, Model model) {
		eventService.deleteEvent(id);
		model.addAttribute("events", eventService.getEvents());
		return "event";
	}
	
	//show vendors of the event
	
	@RequestMapping(value="/event/vendorList", method=RequestMethod.GET)
	public String getAllVendors(Model model) {
		
		System.out.println("Vendors List");
		
		model.addAttribute("vendors", eventService.getVendors());
			
		/*return "redirect:/events";*/
		
		return "eventVendors";
		
	}
	
	//add vendor
	
	@RequestMapping(value = "/event/eventAddVendor", method = RequestMethod.GET)
	public String addVendor(@ModelAttribute("vendor") Vendor vendor, @ModelAttribute("id") Integer id, ModelMap model) {
		
		if(vendor.getId() == 0) {
			
			eventService.addVendor(id);
		} else {
			//eventService.editEvent(event);
			//update
		}
		model.addAttribute("events", eventService.getEvents());

		return "eventVendors";
	}
	
	

}
