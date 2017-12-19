package org.fleamarket.service;

import javax.transaction.Transactional;

import org.fleamarket.domain.Review;
import org.hibernate.SessionFactory;

public class ReviewService {

	private SessionFactory sessionFactory;

	public ReviewService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void addReview(Review review) {
		sessionFactory.getCurrentSession().persist(review);
	}
}
