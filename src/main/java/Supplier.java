import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Basic outline for Supplier class
 * Contains getters and setter for variables
 * @author Samuel McCosh
 */

@Entity
@Table (name = "supplier")
public class Supplier {

	@Id
	@Column (name = "aid")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int supplierID;
	
	@Column (name = "supplierName", nullable = false, length = 200)
	@Size (min = 1, max = 200)
	private String supplierName;
	
	@Column (name = "telNo", nullable = false, length = 11)
	@Size (min = 7, max = 11)
	private String telephoneNumber;
	
	@Column (name = "emailAddr", nullable = false, length = 200)
	@Size (min = 7, max = 200)
	private String emailAddress;
	
	public int getSupplierID() {
		return supplierID;
		
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String name) {
		this.supplierName = name;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	/**
	 * Add code to pull from database
	 */
	
}
