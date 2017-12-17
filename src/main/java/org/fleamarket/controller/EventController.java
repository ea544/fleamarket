package org.fleamarket.controller;

import org.fleamarket.domain.Address;
import org.fleamarket.domain.Event;
import org.fleamarket.domain.Vendor;
import org.fleamarket.service.EventService;
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
	EventService eventService;
	
	
	
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
		eventService.createEvent(event);
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
	
	@RequestMapping(value="/event/editForm/{id}", method=RequestMethod.POST)
	public String editEvent(@ModelAttribute("event")Event event, @PathVariable int id) {
		eventService.editEvent(event);
		return "eventForm";
	}
	
	//Search an event
	
	/*@RequestMapping(value="/eventForm/{id}", method=RequestMethod.POST)
	public String searchEvent(@ModelAttribute("event")Event event, @PathVariable int id) {
		eventService.searchEvent(id);
		return "redirect:/events";
	}	
	
	//delete event
	
	@RequestMapping(value="/eventForm/{id}", method=RequestMethod.POST)
	public String deleteEvent(@ModelAttribute("event")Event event, @PathVariable int id) {
		eventService.deleteEvent(id);
		return "redirect:/events";
	}*/


}
