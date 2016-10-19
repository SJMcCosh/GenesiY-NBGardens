package com.genesisY.nbGardens.services;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entityManagers.ProductManager;


@RequestScoped
public class ProductService {
	
	@Inject
	private ProductManager productInt;
	
	
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
