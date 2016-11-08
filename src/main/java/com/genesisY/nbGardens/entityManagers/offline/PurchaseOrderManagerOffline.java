package com.genesisY.nbGardens.entityManagers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.PurchaseOrder;
import com.genesisY.nbGardens.entityManagers.PurchaseOrderManager;
import com.genesisY.nbGardens.initialData.ImsInitialData;

@Default
@Stateless
public class PurchaseOrderManagerOffline implements PurchaseOrderManager {

	
	@Inject
	private ImsInitialData initialData;
	
	
	
	@Override
	public void addPurchaseOrder(PurchaseOrder p) {
		// TODO Auto-generated method stub
		
		initialData.addPurchaseOrder(p);
		
		
	}



	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		List<PurchaseOrder> purchaseOrders = initialData.getPurchaseOrderList();
		return purchaseOrders; 
	}
	

	
	
}
