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
		Integer id = 0;
		try {
			id = vendor.getId();
			vendorService.updateVendor(vendor);
			//When we update product we don't go to update pictures too.
			// so redirect to profile
			//return "redirect:/products/productProfile/"+id;
		}
		catch(Exception e) {
			System.out.println("The id is zero so we are creating");
			e.printStackTrace();
			id = vendorService.createVendor(vendor);
		}
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
	 * Displays the vendor update form
	 * 
	 * @return
	 */
	@RequestMapping(value="/vendorForm/{id}", method = RequestMethod.GET)
	public String vendorEditForm(@PathVariable Integer id, ModelMap model) {
		Vendor vendor = vendorService.getVendor(id);
		model.addAttribute("vendor", vendor);
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
