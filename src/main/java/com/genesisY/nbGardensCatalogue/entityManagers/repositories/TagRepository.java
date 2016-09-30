/**
 * Interface to be implemented in online + offline TagManager classes
 * @author Brian McLaughlin
 */
package com.genesisY.nbGardensCatalogue.entityManagers.repositories;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entities.Tag;

public interface TagRepository 
{
	public void createTag(Tag a);
	public void readTagByProductID(Product id);
	public void updateTagWithProduct(Tag a, Product id);
}
