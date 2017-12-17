package org.fleamarket.controller;

import org.fleamarket.domain.Vendor;
import org.fleamarket.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/vendors")
public class VendorController {

	@Autowired
	VendorService vendorService;

	// public VendorController(VendorService vendorService) {
	// this.vendorService = vendorService;
	// }

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
	public String createVendor(@ModelAttribute("vendor") Vendor vendor, ModelMap model) {
		Integer id = vendorService.createVendor(vendor);
		return "redirect:/vendors/vendorProfile/"+id;
	}

	/**
	 * Vendor profile
	 */
	@RequestMapping(value = "/vendorProfile/{id}", method = RequestMethod.GET)
	public String vendorProfile(@PathVariable Integer id, ModelMap model) {
		Vendor vendor = vendorService.getVendor(id);
		model.addAttribute("vendor", vendor);
		return "vendorProfile";
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
