package photoapp.photo;

import org.springframework.data.annotation.Id;

public class Photo {
	
	@Id
	public String id;
	
	public String title;
	public String filepath;
	
	public Photo(String name, String password) {
		super();
		this.title = name;
		this.filepath = password;
	} 
	
	public Photo()
	{		
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return title;
	}
	public void setName(String name) {
		this.title = name;
	}
	public String getPassword() {
		return filepath;
	}
	public void setPassword(String password) {
		this.filepath = password;
	}

}
