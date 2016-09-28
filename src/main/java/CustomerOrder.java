/**
 * This is the outline for the Customer Order class
 * @Aiesha 
 *
 */
public class CustomerOrder {
	
	private int customerOrderID;
	private int fk_customerID;
	private double totalPrice;
	
	public int getCustomerOrderID() {
		return customerOrderID;
	}
	public void setCustomerOrderID(int customerOrderID) {
		this.customerOrderID = customerOrderID;
	}
	public int getFk_customerID() {
		return fk_customerID;
	}
	public void setFk_customerID(int fk_customerID) {
		this.fk_customerID = fk_customerID;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

	

}
