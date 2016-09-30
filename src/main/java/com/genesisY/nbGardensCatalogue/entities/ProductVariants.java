package com.genesisY.nbGardensCatalogue.entities;
import javax.persistence.*;
import javax.validation.constraints.*;


/**
 * 
 */

/**
 * @author Administrator 
 * Created by Callum Holden 28/09/2016
 *
 */
@Entity
@Table (name = "ProductVariants")
public class ProductVariants {
	
	@Id
	@Column (name = "prodVarId")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@NotNull
	private long prodVarId;
	
	@Column (name="stock_levels", nullable = false)	
	@NotNull
	private int stockLevel;
	
	@Column (name="stock_levels", nullable = false)	
	@NotNull
	private double price;
	
	@Column (name="porous", nullable = false)	
	@NotNull
	private boolean porous;
	
	@Column (name="status", nullable = false, length = 225)
	@NotNull
	@Size (min = 5, max = 225)
	private String status;
	
	@OneToOne
	@JoinColumn(name = "productID", nullable = false)
	private long fk_ProductID;
	
	
	public int getStockLevel()
	{	
		return this.stockLevel;	
	}
	
	public void setStockLevel(int v_stockLevel)
	{	
		this.stockLevel = v_stockLevel;	
	}
	
	
	
	public double getPrice()
	{	
		return this.price;	
	}
	
	public void setPrice(double v_price)
	{	
		this.price = v_price;	
	}
	
	
	
	public boolean getPorous()
	{	
		return this.porous;	
	}
	
	public void setPorous(boolean v_porous)
	{	
		this.porous = v_porous;	
	}
	
	
	
	public String getStatus()
	{	
		return this.status;	
	}
	
	public void setStatus(String v_status)
	{	
		this.status = v_status;	
	}
	
	
	
	public long getProductID()
	{
		return this.fk_ProductID;
	}
}
