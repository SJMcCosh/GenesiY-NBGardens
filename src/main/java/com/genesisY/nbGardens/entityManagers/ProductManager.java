package com.genesisY.nbGardens.entityManagers;

import java.util.List;

import com.genesisY.nbGardens.entities.Product;

public interface ProductManager {

	public List<Product> getProducts();
	
	public Product getProduct(long id);
<<<<<<< HEAD
	
	public void updateProduct(Product product);
=======

	public List<Product> getAllProducts();
>>>>>>> 26e01f198892530380de418c9abdf39cee015fe0
}
