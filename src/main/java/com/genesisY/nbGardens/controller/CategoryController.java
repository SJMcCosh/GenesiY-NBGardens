package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.Category;
import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.services.CategoryService;

@SuppressWarnings("serial")
@Named("categories")
@SessionScoped
public class CategoryController implements Serializable {
	
	@Inject
	private CategoryService catService;
	
	@Inject
	private ProductsController prodController;
	
	private DataModel<Category> dataModel;
	
    private Category category;
	//private String name = "";
	
	public String onLoad()
	{
		dataModel = new ListDataModel<Category>(catService.getAllCategories());
		return "categories";
	}

	public DataModel<Category> getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel<Category> dataModel) {
		this.dataModel = dataModel;
	}
	
	public String getAllCategories() {
		dataModel = new ListDataModel<>(catService.getAllCategories());
		return "subcategory";
	}
	
	public String filterByCategory(String catName)
	{
		//String catName = "Seasonal";
		System.out.println(catName);
		prodController.setDataModel(new ListDataModel<Product>(catService.getProductsByCategory(catName)));
		return "subcategory";
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
/*
	public String getName() {
		return category.getName();
	}

	public void setName(String name) {
		this.name = name;
	}*/
	
	}

