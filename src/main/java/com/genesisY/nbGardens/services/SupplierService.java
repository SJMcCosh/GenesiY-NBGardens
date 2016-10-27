package com.genesisY.nbGardens.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Address;
import com.genesisY.nbGardens.entities.Supplier;
import com.genesisY.nbGardens.entityManagers.SupplierManager;
import com.genesisY.nbGardens.entityManagers.offline.SupplierManagerOffline;

@Stateless
public class SupplierService {

	private String name;
	private String phone;
	private String email;
	private Address address;
	@Inject
	private SupplierManager supplierManager;

	public List<Supplier> viewSuppliers() {
		List<Supplier> suppliers = supplierManager.getAllSuppliers();
		return suppliers;

	}

	public void addSupplier(String name, String phone, String email, String addressLine1, String addressLine2,
			String addressLine3, String townCity, String country, String postcode) {

		Supplier s = new Supplier(name, phone, email,
				new Address(addressLine1, addressLine2, addressLine3, townCity, country, postcode));

		if (s != null) {

			supplierManager.addSupplier(s);

		}
	}

}
