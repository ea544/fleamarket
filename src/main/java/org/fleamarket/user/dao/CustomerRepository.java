package org.fleamarket.user.dao;

import java.util.Optional;

import org.fleamarket.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	Customer findById(int id);
	
	// @Modifying
	// @Query("update Customer c set u.name = ?1, u.country = ?2 where u.id = ?3")
	// void updateCustomer(Customer cust);
}
