package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardensCatalogue.entities.Category;
import com.genesisY.nbGardensCatalogue.entityManagers.CategoryManager;

@Named("category")
@SessionScoped
public class CategoryController implements Serializable{
	
	private DataModel<Category> catModel;
	
	@Inject private CategoryManager catManager;

	public DataModel<Category> getCatModel() {
		return catModel;
	}

	public void setCatModel(DataModel<Category> catModel) {
		this.catModel = catModel;
	}
	
	
	public String getAllCategories(){
		catModel = new ListDataModel<>(catManager.getAllCategories().subList(0, catManager.getAllCategories().size()));
		return "department";
	}
	

}