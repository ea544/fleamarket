package org.fleamarket.vendor.dao;

import org.fleamarket.vendor.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vendorRepository")
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

	Vendor findByFirstname(String firstname);

	Vendor findByLastname(String lastname);

	Vendor findByEmail(String email);
}
