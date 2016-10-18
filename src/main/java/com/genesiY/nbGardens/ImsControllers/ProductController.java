package com.genesiY.nbGardens.ImsControllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.businessLogic.ProductService;
import com.genesisY.nbGardensCatalogue.entities.Product;

@Named("products")
@SessionScoped

public class ProductController implements Serializable{

	private Product product;
	private DataModel<Product> dataModel = null;
	
	@Inject
	private ProductService productService;
	
	@SuppressWarnings("unchecked")
	public String allProducts()
	{
		dataModel = new ListDataModel(
				productService.getAllProducts().subList(0, productService.getAllProducts().size()));
		
		return "complete";
	}
	
	
	public DataModel<Product> getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel<Product> dataModel) {
		this.dataModel = dataModel;
	}

	@SuppressWarnings("unchecked")
	public String view(){	

		return "productpage";
	}
	
	public String view(long id){	
	
		return "productpage";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
