package org.fleamarket.controller;

import org.fleamarket.domain.Address;
import org.fleamarket.domain.Event;
import org.fleamarket.domain.Vendor;
import org.fleamarket.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/events")

public class EventController {
	@Autowired
	EventService eventService;
	
	
	@RequestMapping(value = { "", "/event" }, method = RequestMethod.GET)
	public String redirectRoot() {
		return "event";
	}
	
	//save event

	@RequestMapping(value = "/eventForm", method = RequestMethod.POST)
	public String createEvent(@ModelAttribute("event") Event event, ModelMap model) {
		model.addAttribute("title", event.getTitle());
		model.addAttribute("description", event.getDescription());
		model.addAttribute("organizingCostEstimate", event.getOrganizingCostEstimate());
		model.addAttribute("subscriptionFee", event.getSubscriptionFee());
		model.addAttribute("review", event.getReview());
		model.addAttribute("organizer", event.getOrganizer());
		//model.addAttribute("address", event.getAddress());
		eventService.createEvent(event);
		return "redirect:/events";
	}
	
	//Event form

	@RequestMapping(value = "/eventForm", method = RequestMethod.GET)
	public String eventForm(ModelMap model) {
		Event event = new Event();
		model.addAttribute("event", event);
		model.addAttribute("edit", false);
		return "eventForm";
	}

}
