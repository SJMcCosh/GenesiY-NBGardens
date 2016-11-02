package com.genesisY.nbGardens.entityManagers.offline;

import java.util.List;

import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Category;
import com.genesisY.nbGardens.entityManagers.CategoryManager;
import com.genesisY.nbGardens.initialData.ImsInitialData;

public class CategoryManagerOffline implements CategoryManager {
	
	@Inject
	private ImsInitialData initialData;

	@Override
	public List<Category> getAllCategories() {
		return initialData.getCatList();
	}

}
