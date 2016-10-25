package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.ProductService;
import com.genesisY.nbGardens.services.TagService;
import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entities.Tag;

@Named("products")
@SessionScoped

public class ProductsController implements Serializable {

	private Product product;
	private DataModel<Product> dataModel = null;

	private DataModel<Tag> tagModel = null;

	@Inject
	private ProductService productService;
	
	@Inject private TagService tagService;
	
	

	public DataModel<Tag> getTagModel() {
		return tagModel;
	}

	public void setTagModel(DataModel<Tag> tagModel) {
		this.tagModel = tagModel;
	}
	
	public String viewProduct(){
		String name = "Gnome Trek";
		product = productService.getProductByName(name);
		System.out.println(">>>>>>>>>>>>>>>>>>> Product Name = " +product.getName());
		return "productpage";
	}

	@SuppressWarnings("unchecked")
	public String allProducts() {
		String category = "all";
		dataModel = new ListDataModel<Product>(
				productService.getAllProducts(category));
		tagModel = new ListDataModel<Tag>(tagService.getAllTags());
		
		return "subcategory";
	}

	public DataModel<Product> getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel<Product> dataModel) {
		this.dataModel = dataModel;
	}

	@SuppressWarnings("unchecked")
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

}
