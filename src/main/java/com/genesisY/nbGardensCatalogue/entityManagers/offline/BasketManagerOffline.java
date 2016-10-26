package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.BasketItem;
import com.genesisY.nbGardensCatalogue.entityManagers.BasketManager;
import com.genesisY.nbGardensCatalogue.initialData.InitialData;

@Default
public class BasketManagerOffline implements BasketManager{
	
	@Inject
	private InitialData initialData;

//	@Override
//	public Basket getBasket() {
//		// TODO Auto-generated method stub
//		System.out.println("Initial Data Array: " + initialData.getBasketList().get(0).getName());
//		return initialData.getBasketList();
//	}

	@Override
	public List<BasketItem> getBasketItems() {
		// TODO Auto-generated method stub	
		
		return initialData.getBasketList();
	}

	
	
	
	
}
