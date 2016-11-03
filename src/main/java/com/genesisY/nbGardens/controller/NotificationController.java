package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.Notification;
import com.genesisY.nbGardens.services.NotificationService;

@SuppressWarnings("serial")
@Named("notifications")
@SessionScoped
public class NotificationController implements Serializable {
	
	@Inject
	private NotificationService notService;
	
	private DataModel<Notification> dataModel;
	
	public String onLoad()
	{
		setDataModel(new ListDataModel<Notification>(notService.getAllNotifications()));
		return "index";
	}

	public DataModel<Notification> getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel<Notification> dataModel) {
		this.dataModel = dataModel;
	}
	
	

}
