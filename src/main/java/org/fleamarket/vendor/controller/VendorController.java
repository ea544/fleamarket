package org.fleamarket.vendor.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.fleamarket.event.model.Event;
import org.fleamarket.event.services.IEventService;
import org.fleamarket.vendor.model.Vendor;
import org.fleamarket.vendor.service.VendorService;
import org.fleamarket.vendor.validator.VendorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/vendors")
public class VendorController {

	@Autowired
	VendorService vendorService;

	@Autowired
	IEventService eventService;

	@Autowired
	VendorValidator vendorValidator;


	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(vendorValidator);
	}


	/**
	 * This is the home page for vendors
	 */
	@RequestMapping(value = { "", "/vendor" }, method = RequestMethod.GET)
	public String redirectRoot() {
		return "vendor";
	}



	/**
	 * Vendor profile
	 */
	@RequestMapping(value = "/vendorProfile/{id}", method = RequestMethod.GET)
	public String vendorProfile(@PathVariable Integer id, ModelMap model) {
		Vendor vendor = vendorService.findVendorWithEvents(id);
		model.addAttribute("vendor", vendor);
		model.addAttribute("vendorEvents", vendor.getEvents());

		return "vendorProfile";
	}
	
	/**
	 * Displays the vendor update form
	 * 
	 * @return
	 */
	@RequestMapping(value="/vendorForm/{id}", method = RequestMethod.GET)
	public String vendorEditForm(@PathVariable Integer id, ModelMap model) {
		Optional<Vendor> vendor = vendorService.findVendorById(id);
		if (vendor.isPresent()) {
			model.addAttribute("vendor", vendor);
		}
		model.addAttribute("edit", true);
		return "vendorForm";
	}
	
	/**
	 * Displays the vendor form
	 * 
	 * @return
	 */
	@RequestMapping(value = "/vendorForm", method = RequestMethod.GET)
	public String vendorForm(ModelMap model) {
		Vendor vendor = new Vendor();
		model.addAttribute("vendor", vendor);
		model.addAttribute("edit", false);
		return "vendorForm";
	}

	/**
	 * Save a Vendor
	 * 
	 * @param vendor
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/vendorForm", method = RequestMethod.POST)
	public String saveVendor(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "vendorForm";
		}
		Vendor ven = vendorService.saveVendor(vendor);
		return "redirect:/vendors/vendorProfile/" + ven.getId();
	}
	/**
	 * create a list of events with options to subscribe
	 * 
	 */
	@RequestMapping(value = "/vendor/{id}/availableEvents", method = RequestMethod.GET)
	public String subscribeToEventPage(@PathVariable Integer id, ModelMap model) {
		model.addAttribute("events", eventService.getAvailableEvents(vendorService.findVendorById(id).get()));
		model.addAttribute("vendorId", id);
		return "availableEvents";
	}

	/**
	 * create a list of events with options to subscribe
	 * 
	 */
	@RequestMapping(value = "/vendor/{id}/availableEvents/{eventId}", method = RequestMethod.GET)
	public String subscribeToEventAction(@PathVariable("id") Integer id, @PathVariable("eventId") Integer eventId,
			ModelMap model) {
		Vendor vendor = vendorService.findVendorWithEvents(id);
		Event event = eventService.getEventById(eventId);
		event.getVendors().add(vendor);
		eventService.createEvent(event);
		vendorService.subscribeToEvent(vendor, event);

		return "redirect:/vendors/vendorProfile/" + id;
	}
}
