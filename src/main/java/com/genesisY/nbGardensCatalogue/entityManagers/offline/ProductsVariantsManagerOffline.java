package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import java.util.ArrayList;

import com.genesisY.nbGardensCatalogue.entityManagers.ProductsVariantsRepository;

import javax.ejb.Stateless;

@Stateless
public class ProductsVariantsManagerOffline implements ProductsVariantsRepository{

	@Override
	public double readStockLevels(int prodVarId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String readProductStatus(int prodVarId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProductStock(int stockLevel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProductStatus(String status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double readProductPrice(int prodVarId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateProductPrice(double price) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList readProductVariant(int prodVarId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createProductVariant(ArrayList prodVaraiant) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	

}
