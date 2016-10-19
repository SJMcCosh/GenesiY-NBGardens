package com.gensisY.nbgardensIms.entityManagers.offline;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.List;

import com.genesisY.nbGardensIms.initialData.ImsInitialData;
import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entityManagers.ProductManagerInterface;



@Stateless
@Default
public class ProductManagerOffline implements ProductManagerInterface{
	
	
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

	@Override
	public java.util.List<Product> getProduct() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
