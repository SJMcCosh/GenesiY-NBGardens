/**
 * Purchase Order Line Outline
 * @author Thomas Chatterjee
 *
 */
public class PurchaseOrderLine {
	private int lineID;
	private int purchaseOrderID;
	private int productID;
	private int quantity;
	private double price;
	
	public int getLineID() {
		return lineID;
	}
	public void setLineID(int lineID) {
		this.lineID = lineID;
	}
	public int getPurchaseOrderID() {
		return purchaseOrderID;
	}
	public void setPurchaseOrderID(int purchaseOrderID) {
		this.purchaseOrderID = purchaseOrderID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
