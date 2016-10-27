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
	
	public void updateProduct(Product product)
	{
		if (product != null)
		{
			System.out.println("<<<<<<<<<<<<<<<<" + product.getPrice());
			productInt.updateProduct(product);
		}
	}

}
