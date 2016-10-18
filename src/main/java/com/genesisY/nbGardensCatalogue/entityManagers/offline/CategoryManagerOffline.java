package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Category;
import com.genesisY.nbGardensCatalogue.entityManagers.CategoryManager;
import com.genesisY.nbGardensCatalogue.initialData.InitialData;

@Stateless
public class CategoryManagerOffline implements CategoryManager {

	@Inject private InitialData initialData;
	
	public void createCategory(Category x) {
		// add category to database
		// categoryID = generated number
		// categoryName = input
	}

	public void readCategory(Category x) {
		// read category from database
		// search for categoryID from input
		// display category name
	}

	public void updateCategory(Category x) {
		// search for categoryID from input
		// new name = input
		// display category new name
	}

	public void archiveCategory(Category x) {
		// search for categoryID from input
		// set the status of the category to "Inactive"
		// display confirmation message
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return initialData.getCategoryList();
	}

}