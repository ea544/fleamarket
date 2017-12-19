package org.fleamarket.vendor.service;

import java.util.Optional;

import org.fleamarket.vendor.dao.VendorRepository;
import org.fleamarket.vendor.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("vendorService")
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public Vendor saveVendor(Vendor vendor) {
		Vendor ven = vendorRepository.save(vendor);
		return ven;
	}

	@Override
	public Optional<Vendor> findVendorById(Integer id) {
		return vendorRepository.findById(id);
	}

	@Override
	public void updateVendor(Vendor vendor) {
		vendorRepository.save(vendor);
	}
}
