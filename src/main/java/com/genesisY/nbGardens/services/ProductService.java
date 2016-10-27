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

	public List<Product> getAllProducts() {
		try {
			return productInt.getProducts();
		} catch (NullPointerException npr) {
			return null;
		}

	}
	
	public Product getProductByName(String name) {
		try {
			for (Product a:productInt.getProducts())
			{
				if (name.equals(a.getName()))
				{
					return a;
				}
			}
		} catch (NullPointerException npr) {
			return null;
		}
		return null;
	}

	public void addProduct(Integer productID, String name, Double price, String desc, String category, Integer stock,
			String product, Double size, Double weight, Double averageRating) {
		// TODO Auto-generated method stub
		
	}

}
