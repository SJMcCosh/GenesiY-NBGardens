package com.genesisY.nbGardens.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Category;
import com.genesisY.nbGardensCatalogue.entityManagers.CategoryManager;

@Stateless

public class CategoryService {

	@Inject
	private CategoryManager catManager;

	public List<Category> getAllCategories() {

		if (catManager.getAllCategories() != null) {
			return catManager.getAllCategories();
		} else {
			return null;
		}
	}
}
