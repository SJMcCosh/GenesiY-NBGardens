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
 * Stock Alert entity
 * 
 * @author Brian McLaughlin
 *
 */

@Entity
@Table(name = "StockAlert")
public class StockAlert {
	
	@Id
	@Column(name = "stockalertID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "stockAlertDate")
	@NotNull
	@Size(min =2, max = 255)
	private String date;
	
	@Column(name = "stockAlertDetails")
	@NotNull
	@Size(min = 2, max = 255)
	private String details;
	
	public StockAlert (int id, String date, String details)
	{
		this.setId(id);
		this.setDate(date);
		this.setDetails(details);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
}
