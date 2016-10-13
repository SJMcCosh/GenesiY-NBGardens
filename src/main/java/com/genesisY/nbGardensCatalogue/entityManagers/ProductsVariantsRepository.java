/**
 * Interface for the product variants
 * Created By: Callum Holden
 * Created On: 30/09/2016
 */

package com.genesisY.nbGardensCatalogue.entityManagers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.genesisY.nbGardensCatalogue.entities.ProductVariants;

@Stateless
public interface ProductsVariantsRepository {
	
		
	
	/**
	 * The below will read stock levels for a specific product.
	 * We have to pass the product variant id as we might have more than two product variants in future.
	 * Created By: Callum Holden
	 * Created On: 30/09/2016
	 * @param prodVarId
	 * @return
	 */
	public double readStockLevels(int prodVarId);	
	
	
	/**
	 * The below will read the product variant status.
	 * Created By: Callum Holden
	 * Created On: 30/09/2016
	 * @param prodVarId	
	 * @return
	 */
	public String readProductStatus(int prodVarId);
		
	
	
	/**
	 * The below will update the stock levels for a product variant.
	 * Created By: Callum Holden
	 * Created On: 30/09/2016
	 * @param stockLevel
	 */
	public void updateProductStock(int stockLevel);
	
	
	/**
	 * The following will update the status of a product variant.
	 * Created By: Callum Holden
	 * Created On: 30/09/2016
	 * @param status
	 */
	public void updateProductStatus(String status);
	
	
	/**
	 * The following will read the product variant price.
	 * Created By: Callum Holden
	 * Created On: 30/09/2016
	 * @param prodVarId
	 * @return
	 */
	public double readProductPrice(int prodVarId);
	
	//update price
	/**
	 * The following will update the price of the product variant.
	 * Created By: Callum Holden
	 * Created On: 30/09/2016
	 * @param price
	 */
	public void updateProductPrice(double price);
	
	//read product variant
	/**
	 * The following will read a product variant and return an arraylist containing the details.
	 * Created By: Callum Holden
	 * Created On: 30/09/2016
	 * @param prodVarId
	 * @return
	 */
	public List<ProductVariants> readProductVariant(int prodVarId);
	
	//create product variant
	/**
	 * The following will create a product variant.
	 * Created By: Callum Holden
	 * Created On: 30/09/2016
	 * @param prodVaraiant
	 */
	public void createProductVariant(ArrayList prodVaraiant);
		
	
	

}
