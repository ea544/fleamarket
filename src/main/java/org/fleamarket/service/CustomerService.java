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
	public Customer getCustomer(int id) {
//		//TODO: find/get
//		Query query = sessionFactory.getCurrentSession().createQuery("FROM Customer c WHERE c.id = :id");
//		query.setParameter("id", id);
//		Customer customer = (Customer)query.getSingleResult();
		Customer customer = sessionFactory.getCurrentSession().find(Customer.class, id);
		// not recommended to do it like this customer.getReviews().size();
		// when using query, you could use FETCH JOIN to retrieve associations
		// Better even, if you config using JPA and fix the TX manager
		return customer;
	}
	@Transactional
	public List<Customer> findAll(){
		Query<Customer> query = sessionFactory.getCurrentSession().createQuery("FROM Customer");
		return query.getResultList();
	}
}