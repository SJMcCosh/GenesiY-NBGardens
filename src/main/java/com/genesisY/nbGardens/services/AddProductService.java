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
	private Double price;
	private String desc;
	private String supplier;
	private String imageLocation;
	private String specification;
	private Integer stock;
	private Double averageRating;

	@Inject
	private ProductManager productManager;

	public List<Product> viewProducts() {
		List<Product> product = productManager.getAllProducts();
		return product;

	}

	public void addProduct(int productID, String name, Double price, String desc, String supplier, String imageLocation,
			String specification, int stock, Double averageRating) {

		Product p = new Product(productID, name, desc, null, price, specification, stock, null);

		if (p != null) {

			productManager.addProduct(p);

		}
	}

}
