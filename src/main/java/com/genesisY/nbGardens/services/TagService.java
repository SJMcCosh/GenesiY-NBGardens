package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entities.Tag;
import com.genesisY.nbGardensCatalogue.entityManagers.ProductManager;
import com.genesisY.nbGardensCatalogue.entityManagers.TagManager;

@Stateless

public class TagService {

	@Inject
	private TagManager tmo;
	@Inject
	private ProductManager pm;
	
	@SuppressWarnings("null")
	public List<Tag> getAllTags() {
	List<Tag> tList = new ArrayList<Tag>();
		try{
			for (Product p: pm.getProducts()){
				for (Tag t : p.getTagList()){
					if(!tList.contains(t)){
						tList.add(t);
					} 
				}
			}
			System.out.println(">>>>>>>>>>>>>> Got tags");
			return tList;
		} catch (NullPointerException npe){
			System.out.println(">>>>>>>>>>>>>> Not Got tags");

			return null;
		}

		
	}

}