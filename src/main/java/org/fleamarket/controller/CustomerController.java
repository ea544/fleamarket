package org.fleamarket.controller;

import org.fleamarket.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
    

    @RequestMapping(value = "/customerForm", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("customerForm", new Customer());

        return "customerForm";
    }

    @RequestMapping(value = "/customerForm", method = RequestMethod.POST)
    public String registration(@ModelAttribute("customerForm") Customer customerForm, Model model) {
       // userService.save(customerForm);
        return "customerList";
    } 
}
