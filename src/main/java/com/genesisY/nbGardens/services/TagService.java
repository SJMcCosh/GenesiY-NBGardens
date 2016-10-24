package com.genesisY.nbGardens.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Tag;
import com.genesisY.nbGardensCatalogue.entityManagers.TagManager;

@Stateless

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
