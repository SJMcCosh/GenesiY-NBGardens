package com.genesisY.nbGardens.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardensCatalogue.entities.Category;
import com.genesisY.nbGardensCatalogue.entityManagers.CategoryManager;

@Stateless

public class CategoryService {

	@Inject
	private CategoryManager catManager;

	/**
	 * 
	 * @return A list of all categories.
	 */
	public List<Category> getAllCategories() {

		if (catManager.getAllCategories() != null) {
			return catManager.getAllCategories();
		} else {
			return null;
		}
	}
	/**
	 * 
	 * @param department
	 * @return A list of all categories in a department 
	 */
	public List<Category> getCategoryByDepartment(String department) {

		if (catManager.getCategoryByDepartment(department) != null) {
			return catManager.getCategoryByDepartment(department);
		} else {
			return null;
		}
	}
}
