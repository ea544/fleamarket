package org.fleamarket.service;

import org.fleamarket.domain.Vendor;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class VendorService {

	private SessionFactory sessionFactory;

	public VendorService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void createVendor(Vendor vendor) {
		sessionFactory.getCurrentSession().persist(vendor);
	}
}
