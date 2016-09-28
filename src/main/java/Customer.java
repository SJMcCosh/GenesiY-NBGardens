import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NotNull;
import javax.persistence.Size;



/**
 * 
 */

/**
 * @author Administrator
 *
 */
// Karrus  - customer class, setting/getting customer passwords and usernames
@Entity
@Table (name = "customer")
public class Customer {
	@Id
	@Column (name = "username")
	@NotNull
	@Size (min = 5, max = 225)
	private String Username; 
	
	
	@Column (name = "password")
	@NotNull
	@Size (min = 5, max = 225)
	private String Password; 
	
	public String getUsername (){
		return Username;
		
	}
	
	public String getPassword (){
		return Password;
		
	}
	
	public void setUsername (String vUsername) {
		this.Username = vUsername;   
	}
	
	public void setPassword (String vPassword) {
		this.Password = vPassword;   
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
