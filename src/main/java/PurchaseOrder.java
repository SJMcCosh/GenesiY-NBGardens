/**
 * Purchase Order Outline
 * @author Thomas Chatterjee
 *
 */
public class PurchaseOrder {
	private int purchaseID;
	private double totalPrice;
	private int supplierID;
	private String imUsername;
	
	public int getPurchaseID() {
		return purchaseID;
	}
	public void setPurchaseID(int purchaseID) {
		this.purchaseID = purchaseID;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	public String getIMUsername() {
		return imUsername;
	}
	public void setIMUsername(String imUsername) {
		this.imUsername = imUsername;
	}
}
