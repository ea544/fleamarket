package org.fleamarket.controller;

import javax.validation.Valid;

import org.fleamarket.domain.Customer;
import org.fleamarket.service.CustomerService;
import org.fleamarket.user.service.RoleService;
import org.fleamarket.user.service.UserService;
import org.fleamarket.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
	@Autowired
    private CustomerService customerService;
	
	@Autowired
	private UserService userService;
	


	@Autowired
	private RoleService roleService;

	@Autowired
	CustomerValidator customerValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(customerValidator);
	}

    @RequestMapping(value = "/customerForm", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("customerForm", new Customer());
        model.addAttribute("edit", false);
        return "customerForm";
    }
    
    @RequestMapping(value = "/customerForm/{cusId}", method = RequestMethod.GET)
    public String registrationEdit(@PathVariable("cusId") int cusId, Model model) {
        
    	Customer customer = customerService.getCustomer(cusId);
    	model.addAttribute("customerForm", customer);
    	model.addAttribute("edit", true);
        return "customerForm";
    }

    @RequestMapping(value = "/customerForm", method = RequestMethod.POST)
	public String registrationSave(@Valid @ModelAttribute("customerForm") Customer customerForm, BindingResult result,
			Model model) {
    	
    	if(result.hasErrors()) {
    		return "customerForm";
    	}
    	else { 
    	customerService.registerCustomer(customerForm);
    	//return "login";
       return "redirect:/login";
    	//return "redirect:/confirmation";
    	}
    } 
    
    @RequestMapping(value = "/customerForm/{cusId}", method = RequestMethod.POST)
	public String registrationUpdate(@Valid @ModelAttribute("customerForm") Customer customerForm, BindingResult result,
			Model model) {
    	
    	if(result.hasErrors()) {
    		return "customerForm";
    	}
    	else { 
    	customerService.registerCustomer(customerForm);
    	//return "login";
       return "redirect:/login";
    	//return "redirect:/confirmation";
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
