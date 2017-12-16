package org.fleamarket.controller;

import org.fleamarket.domain.Vendor;
import org.fleamarket.service.VendorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/vendors")
public class VendorController {

	VendorService vendorService;

	public VendorController(VendorService vendorService) {
		this.vendorService = vendorService;
	}

	/**
	 * This is the home page for vendors
	 */
	@RequestMapping(value = { "/", "vendor" }, method = RequestMethod.GET)
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
	@RequestMapping(value = "venderForm", method = RequestMethod.POST)
	public String createVendor(@ModelAttribute("vendor") Vendor vendor, ModelMap model) {
		model.addAttribute("firstname", vendor.getFirstname());
		model.addAttribute("lastname", vendor.getLastname());
		model.addAttribute("email", vendor.getEmail());
		vendorService.createVendor(vendor);
		return "redirect:vendor";
	}

	/**
	 * Displays the vendor form
	 * 
	 * @return
	 */
	@RequestMapping(value = "venderForm", method = RequestMethod.GET)
	public String vendorForm(ModelMap model) {
		Vendor vendor = new Vendor();
		model.addAttribute("vendor", vendor);
		model.addAttribute("edit", false);
		return "vendorForm";
	}
}
