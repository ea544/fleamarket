package org.fleamarket.service;



import org.fleamarket.domain.Review;
import org.fleamarket.user.dao.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	public ReviewService() {
	}
	
	public void addReview(Review review) {
		reviewRepository.save(review);
	}
}
