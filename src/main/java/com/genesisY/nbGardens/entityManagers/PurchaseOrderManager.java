package com.genesisY.nbGardens.entityManagers;

import java.util.List;

import com.genesisY.nbGardens.entities.PurchaseOrder;
import com.genesisY.nbGardens.entities.Supplier;

public interface PurchaseOrderManager {

	void addPurchaseOrder(PurchaseOrder p);
	public List<PurchaseOrder> getAllPurchaseOrders();
	
	
	}
