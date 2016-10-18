package com.genesisY.nbGardensCatalogue.entityManagers;

import java.util.List;

import javax.ejb.Stateless;

import com.genesisY.nbGardensCatalogue.entities.Category;

@Stateless
public interface CategoryManager {

	public void createCategory(Category x);

	public void readCategory(Category x);

	public void updateCategory(Category x);

	public void archiveCategory(Category x);
	
	public List<Category> getAllCategories();

}
