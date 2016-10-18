package com.genesisY.nbGardens.services;

import java.util.List;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Category;
import com.genesisY.nbGardensCatalogue.entityManagers.CategoryManager;

<<<<<<< HEAD:src/main/java/com/genesisY/nbGardens/services/CategoryService.java

=======
>>>>>>> 693fb77a68a2e9fb34b91909595ae8884cd1d842:src/main/java/com/genesisY/nbGardens/businessLogic/CategoryService.java
@RequestScoped
public class CategoryService {
	
	@Inject private CategoryManager catManager;
	
	public List<Category> getAllCategories(){
<<<<<<< HEAD:src/main/java/com/genesisY/nbGardens/services/CategoryService.java
		
		if(catManager.getAllCategories() != null){
			return catManager.getAllCategories();	
		}
		else{
			return null;
		}
		
=======
		return null;
>>>>>>> 693fb77a68a2e9fb34b91909595ae8884cd1d842:src/main/java/com/genesisY/nbGardens/businessLogic/CategoryService.java
	}

}
