package com.genesisY.nbGardens.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Supplier;
import com.genesisY.nbGardens.entityManagers.SupplierManager;

@Stateless
public class SupplierService {

	@Inject
	private SupplierManager supplierManager;
	
	public List<Supplier> viewSuppliers(){
		List<Supplier> suppliers = supplierManager.getAllSuppliers();
		return suppliers; 
		
	}
	
	
}
