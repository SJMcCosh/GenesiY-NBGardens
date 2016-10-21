/**
 * Interface to be implemented in online + offline TagManager classes
 * @author Brian McLaughlin
 */
package com.genesisY.nbGardensCatalogue.entityManagers;

import java.util.List;

import javax.ejb.Stateless;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entities.Tag;


public interface TagManager {
	public void createTag(Tag a);

	public void readTagByProductID(Product id);

	public void updateTagWithProduct(Tag a, Product id);
	
	public List<Tag> getAllTags();
}
