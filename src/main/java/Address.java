
public class Address {

	private int ID;
	private String HouseNmNo;
	private String Street;
	private String TownCity;
	private String County;
	private String Postcode;

	public void getID(int ID){
		this.ID = ID;
	}
	
	public void getHouse(String HouseNmNo) {
		this.HouseNmNo = HouseNmNo;
	}
	
	public void getStreet(String Street) {
		this.Street = Street;
	}
	
	public void getTownCity(String TownCity) {
		this.TownCity = TownCity;
	}
	
	public void getCounty(String County) {
		this.County = County;
	}
	
	public void getPostcode(String Postcode) {
		this.Postcode = Postcode;
	}
	
	public int ID() {
		return ID;
	}
	
	public String getHouse() {
		return HouseNmNo;
	}
	
	public String getStreet() {
		return Street;
	}
	
	public String getTownCity() {
		return TownCity;
	}
	
	public String getCounty() {
		return County;
	}
	
	public String getPostcode() {
		return Postcode;
	}
	
}
