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
	private ImsInitialData initialData;
	
	
	@Override
	public void addSupplier(Supplier supplier) {
		/*for (Supplier supplier1 : initialData.getSupplierList()){
			if(supplier1.getSupplierName().equals(supplier.getSupplierName())){
			}*/
		initialData.addSupplier(supplier);	
		}
	//}

	@Override
	public void updateSupplier(Supplier supplier) {
	}

	@Override
	public void deleteSupplier(Supplier supplier) {
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
		return null;
	}
}