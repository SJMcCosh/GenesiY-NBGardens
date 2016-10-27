package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Category;
import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entityManagers.ProductManager;

@Stateless
public class CategoryService {
	
	@Inject
	private ProductManager prodInt;
	
	public List<Category> getAllCategories()
	{
		List<Category> cl1 = new ArrayList<Category>();
		for(Product a:prodInt.getAllProducts())
		{
			for(Category c:a.getCatList())
			{
				if(!cl1.contains(c))
				{
					cl1.add(c);
				}
			}
		}
		return cl1;
	}

}
