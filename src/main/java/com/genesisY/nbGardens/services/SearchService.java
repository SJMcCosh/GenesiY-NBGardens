package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entityManagers.ProductManager;

@Stateless
public class SearchService {
	
	@Inject 
	private ProductManager prodManager;
	
	public List<Product> prodSearch(String term)
	{
		ArrayList<Product> prodArray = new ArrayList<Product>();		
		for(Product p:prodManager.getAllProducts())
		{
			if (p.getName().toLowerCase().contains(term.toLowerCase()))
			{
				prodArray.add(p);		
			}
		}
		return prodArray;
	}
}
