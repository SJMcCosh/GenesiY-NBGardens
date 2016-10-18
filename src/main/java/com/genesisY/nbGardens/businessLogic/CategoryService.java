package com.genesisY.nbGardens.businessLogic;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Category;
import com.genesisY.nbGardensCatalogue.entityManagers.CategoryManager;

@RequestScoped
public class CategoryService {
	
	@Inject private CategoryManager catRepo;
	
	public List<Category> getAllCategories(){
		return null;
	}

}
