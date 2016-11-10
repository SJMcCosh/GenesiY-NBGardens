package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.BasketItem;
import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entityManagers.BasketManager;
import com.genesisY.nbGardensCatalogue.initialData.InitialData;

@Default
@Stateful
public class BasketManagerOffline implements BasketManager{
	
	@Inject
	private InitialData initialData;



	@Override
	public List<BasketItem> getBasketItems() {
		// TODO Auto-generated method stub	
		
		return initialData.getBasketList();
	}

	@Override
	public void addProductToCart(Product product, int quantity) {
		
		BasketItem bi = new BasketItem(product, quantity);
		boolean foundProdId = false;
		
		for(BasketItem b : initialData.getBasketList())
		{
			if (b.getProduct().getId() == product.getId())
			{
				b.setQuantity(b.getQuantity() + quantity);
				foundProdId = true;
				break;
			}
		}
		
		if(foundProdId == false)
		{
			initialData.addBasketItem(bi);
		}
	}

	
	
	
	
}
