package org.fleamarket.controller;



import java.security.Principal;

import org.fleamarket.domain.Customer;
import org.fleamarket.domain.Review;
import org.fleamarket.event.model.Address;
import org.fleamarket.service.ReviewService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
public class ReviewController {
	// @Autowired
    private ReviewService reviewService;
	
	@RequestMapping(value = "/addReview", method = RequestMethod.GET)
	public String addReview(Model model,Principal principal) {
		Review review = new Review();
		review.setCustomer(new Customer(1,"ss","ss",new Address("","","",0,"")));
		
		model.addAttribute("addReview", review);

		return "addReview";
	 }
	
	@RequestMapping(value = "/addReview", method = RequestMethod.POST)
    public String addReview(@ModelAttribute("addReview") Review review,@RequestParam("customerId") Integer customerId, Model model) {
		//System.out.println("***************************************" + review.getCustomer());
    	//int id = review.getCustomer().getId();
		Customer cust=new Customer();
		cust.setId(customerId);
		review.setCustomer(cust);
		reviewService.addReview(review);
        return "customerDetails";
    } 
}
