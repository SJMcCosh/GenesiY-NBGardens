package com.genesisY.nbGardens.entityManagers.offline;

import java.util.List;

import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Notification;
import com.genesisY.nbGardens.entityManagers.NotificationManager;
import com.genesisY.nbGardens.initialData.ImsInitialData;

public class NotificationManagerOffline implements NotificationManager {
	
	@Inject
	private ImsInitialData initialData;

	@Override
	public List<Notification> getAllNotifications() {
		return initialData.getNotList();
	}

}