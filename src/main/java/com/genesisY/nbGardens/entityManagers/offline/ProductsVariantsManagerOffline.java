package com.genesisY.nbGardens.entityManagers.offline;

import java.util.ArrayList;

import javax.ejb.Stateless;

import com.genesisY.nbGardens.entityManagers.ProductsVariantsRepository;

@Stateless
public class ProductsVariantsManagerOffline implements ProductsVariantsRepository{

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
