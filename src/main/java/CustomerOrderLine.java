/*
 * Customer Order Line outline
 * @author Brian McLaughlin
 */
public class CustomerOrderLine 
{
	private int id;
	private int customerOrderID;
	private int productID;
	private int quantity;
	private double price;
	
	public int getCustomerOrderID() 
	{
		return customerOrderID;
	}
	public void setCustomerOrderID(int customerOrderID) 
	{
		this.customerOrderID = customerOrderID;
	}
	
	public int getProductID() 
	{
		return productID;
	}
	public void setProductID(int productID) 
	{
		this.productID = productID;
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
