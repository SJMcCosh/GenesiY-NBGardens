package com.genesisY.nbGardens.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Notification;
import com.genesisY.nbGardens.entityManagers.NotificationManager;

@Stateless
public class NotificationService {
	
	@Inject
	private NotificationManager notManager;
	
	public List<Notification> getAllNotifications()
	{
		if (notManager.getAllNotifications() != null)
		{
			return notManager.getAllNotifications();
		}
		else
		{
			return null;
		}
	}

}
