package com.genesisY.nbGardens.businessLogic;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entityManagers.ProductManagerInterface;

@RequestScoped
public class ProductService {

	@Inject
	private ProductManagerInterface productInt;
	
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts(String category) {
		try {
			if (category != null) {
				return  productInt.getProduct();
			}
		} catch (NullPointerException npe) {
			
		}
		
		
		return null;
	}
	
}
