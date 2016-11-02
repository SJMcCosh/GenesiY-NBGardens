package com.genesisY.nbGardens.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.Category;
import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.services.CategoryService;

@Named("categories")
@RequestScoped
public class CategoryController {
	
	@Inject
	private CategoryService catService;
	
	@Inject
	private ProductsController prodController;
	
	private DataModel<Category> dataModel;
	
    private Category category;
	private String hello = "";
	private String name = "";
	
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
	
	public String filterByCategory()
	{
		String catName = "Pop culture";
		System.out.println("hello");
		prodController.setDataModel(new ListDataModel<Product>(catService.getProductsByCategory(catName)));
		return "subcategory";
	}
	
	public String getHello()
	{
		System.out.println("Test");
		return "hello";
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	}

