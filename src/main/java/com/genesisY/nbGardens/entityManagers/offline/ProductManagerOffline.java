package com.genesisY.nbGardens.entityManagers.offline;

import java.util.ArrayList;
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
	private ImsInitialData initialData;
	
	@Override
	public void addProduct(Product product) {
		initialData.addProduct(product);	
	}
	
	@Override
	public List<Product> getAllProducts() {
	
		List<Product> products = new ArrayList<Product>();
						 
		for (Product p: initialData.getProdList()){
			if (p.isValid() == true){
				products.add(p); 
				System.out.println(">>>>>>"+ p.getName());
			}
		}
		return products; 
	}
	
	@Override
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
		return initialData.getProdList();
	}

	public Product getProduct(long id) {
		return null;
	}

	@Override
	public void updateProduct(Product product) 
	{
		for (Product p:initialData.getProdList())
		{
			if (p.getProductID() == product.getProductID())
			{
				p.setName(product.getName());
				System.out.println(">>>>>>>>" + product.getName());
				p.setPrice(product.getPrice());
				System.out.println(">>>>>>>>>>>>>>" + product.getPrice());
				p.setDesc(product.getDesc());
				System.out.println(">>>>>>>>" + product.getDesc());
				p.setSpecification(product.getSpecification());
				System.out.println(">>>>>>>>" + product.getSpecification());
				p.setStatus(product.isStatus());
				System.out.println(">>>>>>>>" + product.isStatus());
				p.setValid(product.isValid());
				System.out.println(">>>>>>>>" + product.isValid());
				
			}
		}
	}
}
