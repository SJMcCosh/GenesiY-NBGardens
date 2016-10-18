package com.genesisY.nbGardens.services;

import java.util.List;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Category;
import com.genesisY.nbGardensCatalogue.entityManagers.CategoryManager;

@RequestScoped
public class CategoryService {

	@Inject
	private CategoryManager catManager;

	public List<Category> getAllCategories() {

		if (catManager.getAllCategories() != null) {
			return catManager.getAllCategories();
		} else {
			return null;
		}

		return null;
	}

}
