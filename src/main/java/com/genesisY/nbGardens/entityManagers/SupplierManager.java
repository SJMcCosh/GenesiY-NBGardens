package com.genesisY.nbGardens.entityManagers;

import java.util.List;

import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entities.Supplier;

public interface SupplierManager {

	public void addSupplier(Supplier supplier);
	public void updateSupplier(Supplier supplier); 
	public void deleteSupplier(Supplier supplier); 
	public List<Supplier> getAllSuppliers();
	public Supplier getSupplierByName(String name);
	public List<Supplier> getSupplierByProduct(Product product); 
	
}
