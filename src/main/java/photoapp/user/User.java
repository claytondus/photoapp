package photoapp.user;

import org.springframework.data.annotation.Id;

public class User {
	
	@Id
	public String id;
	
	public String name;
	public String password;
	
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	} 
	
	public User()
	{		
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
