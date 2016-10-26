package com.genesisY.nbGardens.entityManagers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entities.Supplier;
import com.genesisY.nbGardens.entityManagers.SupplierManager;
import com.genesisY.nbGardens.initialData.ImsInitialData;

@Default
@Stateless
public class SupplierManagerOffline implements SupplierManager {
	
	@Inject
	ImsInitialData initialData;
	
	
	@Override
	public void addSupplier(Supplier supplier) {
		
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		List<Supplier> suppliers = initialData.getSupplierList();
		return suppliers; 
	}

	@Override
	public Supplier getSupplierByName(String name) {
		for (Supplier supplier: initialData.getSupplierList()){
			if (name.equals(supplier.getSupplierName())){
				return supplier;
			}
		}
		return null;
	}

	@Override
	public List<Supplier> getSupplierByProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
