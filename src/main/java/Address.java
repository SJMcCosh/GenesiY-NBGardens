/**
 * Basic outline for Address class
 * Contains getters and setter for variables
 * @author Samuel McCosh
 */
public class Address {

	private int addressID;
	private String houseNmNo;
	private String street;
	private String townCity;
	private String county;
	private String postcode;
	public int getAddressID() {
		return addressID;
	}
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
	public String getHouseNmNo() {
		return houseNmNo;
	}
	public void setHouseNmNo(String houseNmNo) {
		this.houseNmNo = houseNmNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTownCity() {
		return townCity;
	}
	public void setTownCity(String townCity) {
		this.townCity = townCity;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	/**
	 * Add code to pull from database
	 */
	
}
