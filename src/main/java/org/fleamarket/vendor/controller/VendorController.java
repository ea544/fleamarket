package org.fleamarket.vendor.controller;

import java.util.Optional;

import org.fleamarket.vendor.model.Vendor;
import org.fleamarket.vendor.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/vendors")
public class VendorController {

	@Autowired
	VendorService vendorService;

	/**
	 * This is the home page for vendors
	 */
	@RequestMapping(value = { "", "/vendor" }, method = RequestMethod.GET)
	public String redirectRoot() {
		return "vendor";
	}

	/**
	 * Save a Vendor
	 * 
	 * @param vendor
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/vendorForm", method = RequestMethod.POST)
	public String saveVendor(@ModelAttribute("vendor") Vendor vendor) {
		Vendor ven = vendorService.saveVendor(vendor);
		return "redirect:/vendors/vendorProfile/" + ven.getId();
	}

	/**
	 * Vendor profile
	 */
	@RequestMapping(value = "/vendorProfile/{id}", method = RequestMethod.GET)
	public String vendorProfile(@PathVariable Integer id, ModelMap model) {
		Optional<Vendor> vendor = vendorService.findVendorById(id);
		if (vendor.isPresent()) {
			model.addAttribute("vendor", vendor);
		}
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
}
