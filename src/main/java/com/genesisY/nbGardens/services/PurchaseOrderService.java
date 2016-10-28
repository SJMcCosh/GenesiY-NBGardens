package com.genesisY.nbGardens.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Address;
import com.genesisY.nbGardens.entities.Employee;
import com.genesisY.nbGardens.entities.EmployeeLogin;
import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entities.PurchaseOrder;
import com.genesisY.nbGardens.entities.Supplier;
import com.genesisY.nbGardens.entityManagers.PurchaseOrderManager;
import com.genesisY.nbGardens.entityManagers.SupplierManager;
import com.genesisY.nbGardens.entityManagers.offline.SupplierManagerOffline;

@Stateless
public class PurchaseOrderService {

	
	private String name; 
	private String phone; 
	private String email; 
	private Address address; 
	@Inject
	private PurchaseOrderManager purchaseOrderManager; 


	public void createPurchaseOrder(double totalPrice, Supplier supplier, EmployeeLogin employee, List<Product> prodList ){
		
	PurchaseOrder p = new PurchaseOrder(totalPrice, supplier, employee, prodList);
	
	if (p != null)
	{    
		purchaseOrderManager.addPurchaseOrder(p);
	}
	
}
}
