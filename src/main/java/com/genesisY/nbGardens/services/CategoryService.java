package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Category;
import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entityManagers.CategoryManager;
import com.genesisY.nbGardens.entityManagers.ProductManager;

@Stateless
public class CategoryService {
	
	@Inject
	private ProductManager prodInt;
	
	@Inject
	private CategoryManager catManager;
	
	public List<Category> getAllCategories() {
		if (catManager.getAllCategories() != null)
		{
			return catManager.getAllCategories();
		}
		else
		{
			return null;
		}
	}
	
	public List<Category> getAllCategoryProducts()
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
	
	public List<Product> getProductsByCategory(String catName)
	{
		List<Product> prodList = new ArrayList<Product>();
		int i = 0;
		for(Product a:prodInt.getAllProducts())
		{
			for (Category c : a.getCatList())
			{
				if(c.getName().equals(catName)){
					prodList.add(a);
					System.out.println(">>>>>>>>>>>>>>>>>" +prodList.get(i).getName());
					i++;	
				}
				
			}
		}
		
		return prodList;
	}

}
