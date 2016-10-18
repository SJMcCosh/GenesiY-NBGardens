package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import java.util.ArrayList;

import javax.ejb.Stateless;

import com.genesisY.nbGardensCatalogue.entities.PurchaseOrder;
import com.genesisY.nbGardensCatalogue.entityManagers.PurchaseOrderManager;

@Stateless
public class PurchaseOrderManagerOffline implements PurchaseOrderManager {

	public void createPurchOrd(PurchaseOrder po) {
		// adds purchase order to DB

	}

	public ArrayList<PurchaseOrder> readPurchaseOrders() {
		// grabs purchase order from db
		return null;
	}

	public void updatePurchaseOrder(PurchaseOrder po) {
		// updates a purchase order

	}
}
