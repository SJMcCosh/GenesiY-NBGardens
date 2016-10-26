package com.genesisY.nbGardens.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Address;
import com.genesisY.nbGardens.entities.Supplier;
import com.genesisY.nbGardens.entityManagers.SupplierManager;

@Stateless
public class SupplierService {

	
	private String name; 
	private String phone; 
	private String email; 
	private Address address; 
	@Inject
	private SupplierManager supplierManager;
	
	public List<Supplier> viewSuppliers(){
		List<Supplier> suppliers = supplierManager.getAllSuppliers();
		return suppliers; 
		
	}
	
	

	
}
