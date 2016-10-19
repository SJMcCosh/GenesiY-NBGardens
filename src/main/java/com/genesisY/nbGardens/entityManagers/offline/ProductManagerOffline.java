package com.genesisY.nbGardens.entityManagers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entityManagers.ProductManager;
import com.genesisY.nbGardens.initialData.ImsInitialData;



@Stateless
@Default
public class ProductManagerOffline implements ProductManager{
	
	
	@Inject
	private ImsInitialData initialData;
	
	@Override
	public List<Product> getProducts() {
		
		return initialData.getProdList();
	}

	@Override
	public Product getProduct(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
