package org.fleamarket.controller;

import java.security.Principal;

import org.fleamarket.domain.Customer;
import org.fleamarket.domain.Review;
import org.fleamarket.event.model.Address;
import org.fleamarket.product.model.Product;
import org.fleamarket.service.CustomerService;
import org.fleamarket.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {
	@Autowired
    private ReviewService reviewService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/addReview", method = RequestMethod.GET)
	public String addReview(@RequestParam("cid") int customer_id,  @RequestParam("pid") int product_id, 
			Model model,Principal principal) {
		
		model.addAttribute("product_id", product_id);
		model.addAttribute("customer_id", customer_id);
		model.addAttribute("addReview", new Review());

		return "addReview";
		//addReview?cid=1&pid=1
	 }
	
	@RequestMapping(value = "/addReview", method = RequestMethod.POST)
    public String addReview(@ModelAttribute("addReview") Review review,@RequestParam("customerId") Integer customerId,@RequestParam("productId") Integer productId, Model model) {
	
		System.out.println("***************************************________________*********************************** id:: " + customerId);
		Customer cust = new Customer();//customerService.getCustomer(customerId);
		cust.setId(customerId);
		Product prod = new Product();
		prod.setId(productId);
		System.out.println("***************************************________________*********************************** cu:: " + cust);
		
		review.setProduct(prod);
		review.setCustomer(cust);
		//System.out.println("***************************************");
		reviewService.addReview(review);
		
		
		model.addAttribute("customer", customerService.getCustomer(customerId));
		
        return "customerDetails";
    } 
}
