import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NotNull;
import javax.persistence.Size;



/**
 * customer class, setting/getting customer passwords and usernames
 * @author Karrus
 */
<<<<<<< HEAD

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
		
=======
public class Customer {

	private String username; 
	private String password;
	public String getUsername() {
		return username;
>>>>>>> e5a3b367b1b0e6163385a168cc80f62e68ca7c20
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
	
	
	

}
