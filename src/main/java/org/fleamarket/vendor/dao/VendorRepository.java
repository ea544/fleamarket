package org.fleamarket.vendor.dao;

import java.util.List;

import org.fleamarket.vendor.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("vendorRepository")
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

	Vendor findByFirstname(String firstname);

	Vendor findByLastname(String lastname);

	Vendor findByEmail(String email);

	@Query("FROM Vendor v RIGHT JOIN v.event e where v.id = :id")
	List<Vendor> findVendorWithEvents(@Param("id") Integer id);

}
