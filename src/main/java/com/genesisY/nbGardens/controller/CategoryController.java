package com.genesisY.nbGardens.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.Category;
import com.genesisY.nbGardens.services.CategoryService;

@Named("categories")
@RequestScoped
public class CategoryController {
	
	@Inject
	private CategoryService catService;
	
	private DataModel<Category> dataModel;
	
	public void onLoad()
	{
		dataModel = new ListDataModel<Category>(catService.getAllCategories());
	}

	public DataModel<Category> getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel<Category> dataModel) {
		this.dataModel = dataModel;
	}

}
