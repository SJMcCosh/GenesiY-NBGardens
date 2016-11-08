package com.genesisY.nbGardens.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.StockAlert;
import com.genesisY.nbGardens.entityManagers.StockAlertManager;

@Stateless
public class StockAlertService {
	
	@Inject
	private StockAlertManager saManager;
	
	public List<StockAlert> getAllStockAlerts()
	{
		if (saManager.getAllStockAlerts() != null)
		{

			System.out.println(">>>>>>>>>>>>>>>>>>> Service");
			return saManager.getAllStockAlerts();
		}
		else
		{
			return null;
		}
	}
	

}
