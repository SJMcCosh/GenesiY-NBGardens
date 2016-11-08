/**
 * TagManagerOffline class
 * Implements TagRepository interface
 * @author Brian McLaughlin
 */
package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entities.Tag;
import com.genesisY.nbGardensCatalogue.entityManagers.TagManager;
import com.genesisY.nbGardensCatalogue.initialData.InitialData;

@Stateless
@Default
public class TagManagerOffline implements TagManager {
	
	@Inject
	private InitialData initialData;

	public void createTag(Tag a) {

	}

	public void readTagByProductID(Product id) {

	}

	public void updateTagWithProduct(Tag a, Product id) {

	}

	@Override
	public List<Tag> getAllTags() {
		
		return null;
	}

}
