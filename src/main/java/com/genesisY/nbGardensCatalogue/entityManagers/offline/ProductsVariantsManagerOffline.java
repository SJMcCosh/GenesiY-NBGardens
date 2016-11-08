package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import java.util.ArrayList;

import com.genesisY.nbGardensCatalogue.entityManagers.ProductsVariantsManager;

import javax.ejb.Stateless;

@Stateless
public class ProductsVariantsManagerOffline implements ProductsVariantsManager{

	public double readStockLevels(int prodVarId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String readProductStatus(int prodVarId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateProductStock(int stockLevel) {
		// TODO Auto-generated method stub
		
	}

	public void updateProductStatus(String status) {
		// TODO Auto-generated method stub
		
	}

	public double readProductPrice(int prodVarId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void updateProductPrice(double price) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList readProductVariant(int prodVarId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createProductVariant(ArrayList prodVaraiant) {
		// TODO Auto-generated method stub
		
	}

}
