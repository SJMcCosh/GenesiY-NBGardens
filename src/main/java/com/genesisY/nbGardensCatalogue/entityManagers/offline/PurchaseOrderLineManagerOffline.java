package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;

import javax.ejb.Stateless;


import com.genesisY.nbGardensCatalogue.entities.PurchaseOrderLine;
import com.genesisY.nbGardensCatalogue.entityManagers.repositories.PurchaseOrderLineRepository;
import com.genesisY.nbGardensCatalogue.initialData.InitialData;

@Stateless
public class PurchaseOrderLineManagerOffline implements PurchaseOrderLineRepository{
	@Inject
	private InitialData initialData;
	
	public void createPurchaseOrderLine(PurchaseOrderLine pol) {
		// adds a purchase order line to the db
		initialData.addPurchaseOrderLine(pol);
	}
	
	
	public ArrayList<PurchaseOrderLine> readPurchaseOrderLine() {
		// reads a list of purchase order lines from the db
		return initialData.getPolList();
	}
	
	public void updatePurchaseOrderLine(PurchaseOrderLine pol) {
		// updates a purchase order line on the db

	}

	public void removePurchaseOrderLine(PurchaseOrderLine pol) {
		/*
		 * deletes a purchase order line on the db only to be usable on POLs
		 * that are on orders yet to be implemented
		 */

	}


	public void createPurchaseOrderLines(List<PurchaseOrderLine> pol) {
		// TODO Auto-generated method stub
		
	}
}
