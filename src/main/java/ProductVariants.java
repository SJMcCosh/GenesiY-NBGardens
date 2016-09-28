/**
 * 
 */

/**
 * @author Administrator 
 * Created by Callum Talks Out of His Arse DeLacey Holden 28/09/2016
 *
 */
public class ProductVariants {
	private int stockLevel;
	private double price;
	private boolean porous;
	private String status;
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
