package com.genesisY.nbGardens.businessLogic;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entityManagers.ProductManager;
import com.genesisY.nbGardensCatalogue.entityManagers.offline.ProductsManager;

@Singleton
public class ProductsBean {
	
	public List<Product> getProducts(){
		
		ProductManager pm = new ProductsManager();
		ArrayList<Product> productList = (ArrayList<Product>) pm.getProducts();
		return  productList;
	}
	
	public Product getProduct(long id){
		ProductManager pm = new ProductsManager();
		Product p = pm.getProduct(id);
		return p;
	}

}
