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
	private String imageLocation;
	private String specification;
	private Integer stock;
	private Double averageRating;

	@Inject
	private ProductManager productManager;
	@Inject
	private ProductManagerOffline pM;

	public List<Product> viewProducts() {
		List<Product> product = productManager.getAllProducts();
		return product;

	}

	public void addProduct(int productID, String name, Double price, String desc, String imageLocation, String specification, int stock, Double averageRating){
		
	Product p = new Product(productID, name, price, desc, imageLocation, specification, stock, averageRating); 	
		
		if (p != null){
			
			pM.addProduct(p);
			
			}
	}

}
