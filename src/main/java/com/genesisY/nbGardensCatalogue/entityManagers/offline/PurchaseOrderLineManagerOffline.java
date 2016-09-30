package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import java.util.ArrayList;
import java.util.List;

import com.genesisY.nbGardensCatalogue.entities.PurchaseOrderLine;
import com.genesisY.nbGardensCatalogue.entityManagers.repositories.PurchaseOrderLineRepository;

public class PurchaseOrderLineManagerOffline implements PurchaseOrderLineRepository{

	public void createPurchaseOrderLine(PurchaseOrderLine pol) {
		// adds a purchase order line to the db
		
	}

	public void createPurchaseOrderLines(List<PurchaseOrderLine> pol) {
		// adds many purchase order lines to the db
		
	}

	public ArrayList<PurchaseOrderLine> readPurchaseOrderLine() {
		// reads a list of purchase order lines from the db
		return null;
	}

	public void updatePurchaseOrderLine(PurchaseOrderLine pol) {
		// updates a purchase order line on the db
		
	}

	public void removePurchaseOrderLine(PurchaseOrderLine pol) {
		/* deletes a purchase order line on the db
		only to be usable on POLs that are on orders yet to be implemented*/
		
	}

}
