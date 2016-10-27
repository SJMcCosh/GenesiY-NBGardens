package com.genesisY.nbGardens.entityManagers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entityManagers.ProductManager;
import com.genesisY.nbGardens.initialData.ImsInitialData;

@Default
@Stateless
public class ProductManagerOffline implements ProductManager {
	
	@Inject
	ImsInitialData initialData;
	
	@Override
	public void addProduct(Product product) {
		initialData.addProduct(product);	
	}

	public void deleteProduct(Product product) {
		
	}

	public List<Product> getAllProducts() {
		List<Product> products = initialData.getProdList();
		return products; 
	}

	public Product getProductByName(String name) {
		for (Product product: initialData.getProdList()){
			if (name.equals(product.getName())){
				return product;
			}
		}
		return null;
	}

	public List<Product> getProductByProduct(Product product) {
		return null;
	}

	public List<Product> getProducts() {
		return null;
	}

	public Product getProduct(long id) {
		return null;
	}

	@Override
	public void updateProduct(Product product) 
	{
		for (Product p:initialData.getProdList())
		{
			if (p.getId() == product.getId())
			{
				p.setName(product.getName());
				System.out.println(">>>>>>>>" + product.getName());
				p.setPrice(product.getPrice());
				System.out.println(">>>>>>>>>>>>>>" + product.getPrice());
				p.setDescription(product.getDescription());
				System.out.println(">>>>>>>>" + product.getDescription());
				p.setSpecification(product.getSpecification());
				System.out.println(">>>>>>>>" + product.getSpecification());
			}
		}
	}
}
