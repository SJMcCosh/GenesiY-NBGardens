package com.genesisY.nbGardens.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Brian McLaughlin
 *
 */

@Entity
@Table(name = "notification")
public class Notification {
	
	@Id
	@Column(name = "notificationID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notificationID;
	
	@Column(name = "notificationDetails")
	@NotNull
	@Size(min = 2, max = 255)
	private String details;
	
	@Column(name = "notificationDate")
	@NotNull
	@Size(min = 2, max = 255)
	private String date;
	
	public Notification (int id, String details, String date)
	{
		this.setNotificationID(id);
		this.setDetails(details);
		this.setDate(date);
	}

	public int getNotificationID() {
		return notificationID;
	}

	public void setNotificationID(int notificationID) {
		this.notificationID = notificationID;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
