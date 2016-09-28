/*
 * Customer Order Line outline
 * @author Brian McLaughlin
 */
public class CustomerOrderLine 
{
	private int id;
	private int fk_CustomerOrderID;
	private int fk_ProductID;
	private int quantity;
	private double price;

	
	public int getFk_CustomerOrderID() 
	{
		return fk_CustomerOrderID;
	}
	public void setFk_CustomerOrderID(int fk_CustomerOrderID) 
	{
		this.fk_CustomerOrderID = fk_CustomerOrderID;
	}
	
	public int getFk_ProductID() 
	{
		return fk_ProductID;
	}
	public void setFk_ProductID(int fk_ProductID) 
	{
		this.fk_ProductID = fk_ProductID;
	}
	
	public int getQuantity() 
	{
		return quantity;
	}
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	public double getPrice() 
	{
		return price;
	}
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	
}
