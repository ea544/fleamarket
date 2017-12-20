package org.fleamarket.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.fleamarket.domain.Customer;
import org.fleamarket.user.dao.CustomerRepository;
import org.fleamarket.user.dao.UserRepository;
import org.fleamarket.user.model.Role;
import org.fleamarket.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	UserRepository userRepository;

	public CustomerService() {

	}

	
	public void registerCustomer(Customer cust) {
		
		customerRepository.save(cust);
		//System.out.println("*****************************************************Password " + cust.getPassword());
		Set<Role> role = new HashSet<Role>();
		role.add(new Role("CUSTOMER"));
		userRepository.save(new User(cust.getEmail(),cust.getPassword(),role));
		
	}
	
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
		return customerRepository.findAll();
	}
	
	public void deleteCustomer(Customer cust) {
		customerRepository.delete(cust);
	}
	

}