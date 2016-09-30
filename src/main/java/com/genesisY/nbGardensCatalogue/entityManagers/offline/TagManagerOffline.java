/**
 * TagManagerOffline class
 * Implements TagRepository interface
 * @author Brian McLaughlin
 */
package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import javax.ejb.Stateless;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entities.Tag;
import com.genesisY.nbGardensCatalogue.entityManagers.repositories.TagRepository;

@Stateless
public class TagManagerOffline implements TagRepository {

	public void createTag(Tag a) {

	}

	public void readTagByProductID(Product id) {

	}

	public void updateTagWithProduct(Tag a, Product id) {

	}

}
