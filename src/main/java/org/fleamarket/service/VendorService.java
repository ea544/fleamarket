package org.fleamarket.service;

import org.fleamarket.domain.Vendor;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

public class VendorService {

	private SessionFactory sessionFactory;

	public VendorService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Integer createVendor(Vendor vendor) {
		Integer id = (Integer)sessionFactory.getCurrentSession().save(vendor);
		return id;
	}
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public Vendor getVendor(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Vendor v WHERE v.id = :id");
		query.setParameter("id", id);
		Vendor vendor = (Vendor)query.getSingleResult();
		return vendor;
	}
}
