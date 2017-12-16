package org.fleamarket.controller;

import java.sql.Date;

import javax.annotation.Resource;

import org.fleamarket.domain.Event;
import org.fleamarket.interfaces.IEventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/event")
public class EventController {
	
	@Resource
	private IEventService iEventService;
	
	@RequestMapping(value="/eventForm", method=RequestMethod.POST)
	public String createEvent(@ModelAttribute("event") Event event, ModelMap model) {
		model.addAttribute("subscriptionFee", event.getSubscriptionFee());
		model.addAttribute("organizingCostEstimate", event.getOrganizingCostEstimate());
		return "redirect:/event";
	}
	
	@RequestMapping(value="/event", method=RequestMethod.GET)
	public String redirectRoot() {
		return "event";
	}
	
}
