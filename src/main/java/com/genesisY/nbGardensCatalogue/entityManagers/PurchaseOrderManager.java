package com.genesisY.nbGardensCatalogue.entityManagers;

import java.util.ArrayList;

import javax.ejb.Stateless;

import com.genesisY.nbGardensCatalogue.entities.PurchaseOrder;
import com.genesisY.nbGardensCatalogue.entities.Supplier;

/**
 * 
 * @author Thomas Chatterjee Purchase Order Repository interface. Provides
 *         outline for CRUD methods for Purchase Orders
 *
 */

public interface PurchaseOrderManager {
	/**
	 * 
	 * @param Purchase
	 *            Order Method to create a purchase order object
	 */
	public void createPurchOrd(PurchaseOrder po);

	/**
	 * 
	 * @return ArrayList of Purchase Orders Reads purchase orders from data
	 */
	public ArrayList<PurchaseOrder> readPurchaseOrders();

	/**
	 * 
	 * @param Purchase
	 *            Order Updates a purchase order
	 */
	public void updatePurchaseOrder(PurchaseOrder po);
}
