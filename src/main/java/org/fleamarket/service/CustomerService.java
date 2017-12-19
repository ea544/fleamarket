package org.fleamarket.service;

import java.util.List;

import org.fleamarket.domain.Customer;
import org.fleamarket.user.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	public CustomerService() {

	}

	
	public void registerCustomer(Customer cust) {
		customerRepository.save(cust);
		//sessionFactory.getCurrentSession().persist(cust);
	}
	
	// public void updateCustomer(Customer cust) {
	// customerRepository.updateCustomer(cust);
	// }

	
	public Customer getCustomer(int id) {
//		//TODO: find/get
//		Query query = sessionFactory.getCurrentSession().createQuery("FROM Customer c WHERE c.id = :id");
//		query.setParameter("id", id);
//		Customer customer = (Customer)query.getSingleResult();
		//Customer customer = sessionFactory.getCurrentSession().find(Customer.class, id);
		// not recommended to do it like this customer.getReviews().size();
		// when using query, you could use FETCH JOIN to retrieve associations
		// Better even, if you config using JPA and fix the TX manager
		return customerRepository.findById(id);
	}

	public List<Customer> findAll(){
		//Query<Customer> query = sessionFactory.getCurrentSession().createQuery("FROM Customer");
		return customerRepository.findAll();
	}
}