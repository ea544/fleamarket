package org.fleamarket.controller;

import org.fleamarket.domain.Customer;
import org.fleamarket.product.model.Product;
import org.fleamarket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
	@Autowired
    private CustomerService customerService;
	
	
    @RequestMapping(value = "/customerForm", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("customerForm", new Customer());

        return "customerForm";
    }

    @RequestMapping(value = "/customerForm", method = RequestMethod.POST)
    public String registration(@ModelAttribute("customerForm") Customer customerForm, BindingResult result, Model model) {
    	if(result.hasErrors()) {
    		return "customerForm";
    	}
    	else {
    	customerService.registerCustomer(customerForm);
        return "redirect:/login";
    	}
    } 
    
    @RequestMapping(value = "/customerDetails/{id}", method = RequestMethod.GET)
	public String customerDetails(@PathVariable int id, ModelMap model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
	
		return "customerDetails";
	}
    
   
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String customerList(ModelMap model) {
    	model.addAttribute("customers",customerService.findAll());
		return "customerList";
	}
}
