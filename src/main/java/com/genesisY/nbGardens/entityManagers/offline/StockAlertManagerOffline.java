package com.genesisY.nbGardens.entityManagers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.StockAlert;
import com.genesisY.nbGardens.entityManagers.StockAlertManager;
import com.genesisY.nbGardens.initialData.ImsInitialData;

@Default
@Stateless
public class StockAlertManagerOffline implements StockAlertManager {
	
	@Inject
	private ImsInitialData intialData;

	@Override
	public List<StockAlert> getAllStockAlerts() {
		return intialData.getSaList();
	}

	

}
