/**
 * Basic outline for Supplier class
 * Contains getters and setter for variables
 * @author Samuel McCosh
 */
public class Supplier {

	private int SupplierID;
	private String Name;
	private String TelephoneNumber;
	private String EmailAddress;
	

	public void getSupplierID(int SupplierID){
		this.SupplierID = SupplierID;
	}
	
	public void getName(String Name) {
		this.Name = Name;
	}
	
	public void getTelephoneNumber(String TelephoneNumber) {
		this.TelephoneNumber = TelephoneNumber;
	}
	
	public void getEmailAddress(String EmailAddress) {
		this.EmailAddress = EmailAddress;
	}
	
	
	public int SupplierID() {
		return SupplierID;
	}
	
	public String getName() {
		return Name;
	}
	
	public String getTelephoneNumber() {
		return TelephoneNumber;
	}
	
	public String getEmailAddress() {
		return EmailAddress;
	}
	
	/**
	 * Add code to pull from database
	 */
	
}
