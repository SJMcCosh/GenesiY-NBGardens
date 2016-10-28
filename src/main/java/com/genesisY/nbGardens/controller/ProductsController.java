package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.services.ProductService;

@SuppressWarnings("serial")
@Named("products")
@SessionScoped
public class ProductsController implements Serializable {

	private Product product;
	private String price = "";
	private String name = "";
	private String description = "";
	private String specification = "";
	private DataModel<Product> dataModel = null;

	@Inject
	private ProductService prodService;

	public String getAllProducts() {

		dataModel = new ListDataModel<Product>(prodService.getAllProducts());
		return "newpurchaseorder";
	}
	
	public String viewProduct(Product p){ 
		product = prodService.getProductByName(p.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>> Product Name = " +product.getName()); 
		setName(product.getName());
		setPrice(Double.toString(product.getPrice()));
		setDescription(product.getDesc());
		setSpecification(product.getSpecification());
		return "product"; 
	} 
	
	public String onLoad()
	{
		dataModel = new ListDataModel<Product>(prodService.getAllProducts());
		return "subcategory";
	}
	
	public String updateProduct()
	{
		
		product.setName(name);
		//product.setPrice(Double.parseDouble(price));
		product.setDesc(description);
		product.setSpecification(specification);
		System.out.println(">>>>>>>>>>>>" + getPrice());
		prodService.updateProduct(product);
		
		return "product";
	}


	public DataModel<Product> getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel<Product> dataModel) {
		for(Product p : dataModel){
			System.out.println(">>>>>>>>>>>" + p.getDesc());
		}
		this.dataModel = dataModel;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		product.setPrice(Double.parseDouble(price));
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	public String view() {

		return "productpage";
	}

	public String view(long id) {

		return "productpage";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

}
