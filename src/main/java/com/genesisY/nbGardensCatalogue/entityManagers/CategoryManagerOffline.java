package com.genesisY.nbGardensCatalogue.entityManagers;

import com.genesisY.nbGardensCatalogue.entities.Category;

public class CategoryManagerOffline implements CategoryRepository {

	public void createCategory(Category x){
		// add category to database
		// categoryID = generated number 
		// categoryName = input
	}
	
	public void readCategory(Category x){
		// read category from database
		// search for categoryID from input
		// display category name
	}
	
	public void updateCategory(Category x){
		// search for categoryID from input
		// new name = input
		// display category new name
	}
	
	public void archiveCategory(Category x){
		// search for categoryID from input
		// set the status of the category to "Inactive"
		// display confirmation message
	}
	
}