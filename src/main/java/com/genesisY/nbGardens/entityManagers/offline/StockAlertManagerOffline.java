package com.genesisY.nbGardens.entityManagers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Notification;
import com.genesisY.nbGardens.entityManagers.NotificationManager;
import com.genesisY.nbGardens.initialData.ImsInitialData;

@Default
@Stateless
public class StockAlertManagerOffline implements NotificationManager {
	
	@Inject
	private ImsInitialData intialData;

	@Override
	public List<Notification> getAllNotifications() {
		return null;
	}

}
