package com.genesisY.nbGardens.services;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entityManagers.ProductManagerInterface;


@RequestScoped
public class ProductService {
	
	@Inject
	private ProductManagerInterface productInt;
	
	
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts()
	{
		try
		{
			return productInt.getProducts();
		}
		catch(NullPointerException npr)
		{
			return null; 
		}
		
		
	}
	
	
	
	
	

}
