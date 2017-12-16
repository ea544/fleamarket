package org.fleamarket.service;

import javax.transaction.Transactional;

import org.fleamarket.domain.Customer;
import org.hibernate.SessionFactory;

public class CustomerService {
	private SessionFactory sessionFactory;

	public CustomerService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void registerCustomer(Customer cust) {
		sessionFactory.getCurrentSession().persist(cust);
	}
}
