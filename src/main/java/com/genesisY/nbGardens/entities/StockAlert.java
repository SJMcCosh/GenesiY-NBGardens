package com.genesisY.nbGardens.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	
	
	private String date;
	
	@OneToOne
	@JoinColumn(name = "productID_fk", nullable = false)
	@NotNull
	private Product product;
	
}
