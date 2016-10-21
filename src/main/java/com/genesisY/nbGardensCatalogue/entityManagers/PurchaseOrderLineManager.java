package com.genesisY.nbGardensCatalogue.entityManagers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.genesisY.nbGardensCatalogue.entities.PurchaseOrderLine;

/**
 * 
 * @author Thomas Chatterjee Interface for Purchase Order Lines Provides CRUD
 *         outlines for Purchase Order Lines
 *
 */

public interface PurchaseOrderLineManager {
	/**
	 * 
	 * @param Purchase
	 *            Order Line Creates a Purchase Order Line
	 */
	public void createPurchaseOrderLine(PurchaseOrderLine pol);

	/**
	 * 
	 * @param Purchase
	 *            Order Line Creates a list of Purchase Order Lines
	 */
	public void createPurchaseOrderLines(List<PurchaseOrderLine> pol);

	/**
	 * 
	 * @return An arraylist of Purchase Order Lines Reads Purchase Order Lines
	 *         from the database
	 */
	public ArrayList<PurchaseOrderLine> readPurchaseOrderLine();

	/**
	 * 
	 * @param Purchase
	 *            Order Line Updates a Purchase Order Line
	 */
	public void updatePurchaseOrderLine(PurchaseOrderLine pol);

	/**
	 * 
	 * @param Purchase
	 *            Order Line Removes a Purchase Order Line
	 */
	public void removePurchaseOrderLine(PurchaseOrderLine pol);
}
