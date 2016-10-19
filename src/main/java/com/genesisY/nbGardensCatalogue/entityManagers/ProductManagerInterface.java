package com.genesisY.nbGardensCatalogue.entityManagers;
import com.genesisY.nbGardensCatalogue.entities.Product;

import java.util.List;

import javax.ejb.Singleton;

@Singleton
public interface ProductManagerInterface {

	
	public List<Product> getProducts();
	
	public Product getProduct(long id);
	public List<Product> getProduct();
	
	
	
	
	
	
}
