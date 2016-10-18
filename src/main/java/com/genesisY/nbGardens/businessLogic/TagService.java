package com.genesisY.nbGardens.businessLogic;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Tag;
import com.genesisY.nbGardensCatalogue.entityManagers.TagManager;

@RequestScoped
public class TagService {

	@Inject
	private TagManager tmo;
	
	public List<Tag> getAllTags() {
	
		try{
			return tmo.getAllTags();
		} catch (NullPointerException npe){
			return null;
		}

		
	}

}
