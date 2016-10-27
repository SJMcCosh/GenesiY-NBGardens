package com.genesisY.nbGardens.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entityManagers.ProductManager;
import com.genesisY.nbGardens.entityManagers.offline.ProductManagerOffline;

@Stateless
public class AddProductService {

	private String name;

	@Inject
	private ProductManager productManager;

	public List<Product> viewProducts() {
		List<Product> product = productManager.getAllProducts();
		return product;

	}

	public void addProduct(String productID, String name, Double price, String desc, String category, Integer stock,
			String supplier, Double size, Double weight, Double averageRating) {

		Product p = new Product(productID, name, price, desc, category, stock, supplier, size, weight, averageRating);

		if (p != null) {

			productManager.addProduct(p);

		}
	}

}
