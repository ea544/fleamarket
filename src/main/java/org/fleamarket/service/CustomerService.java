package org.fleamarket.service;

import java.util.List;

import javax.transaction.Transactional;

import org.fleamarket.domain.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class CustomerService {
	private SessionFactory sessionFactory;

	public CustomerService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void registerCustomer(Customer cust) {
		sessionFactory.getCurrentSession().persist(cust);
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public Customer getCustomer(String email) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Customer c WHERE c.email = :email");
		query.setParameter("email", email);
		Customer customer = (Customer)query.getSingleResult();
		return customer;
	}
	@Transactional
	public List<Customer> findAll(){
		Query<Customer> query = sessionFactory.getCurrentSession().createQuery("FROM Customer");
		return query.getResultList();
	}
}