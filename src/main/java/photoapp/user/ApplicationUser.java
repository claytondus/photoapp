package photoapp.user;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

public class ApplicationUser {
	
	@Id
	public String id;
	
	public String name;
	public String password;
	public List<GrantedAuthority> authorities;
	
	public ApplicationUser(String name, String password,String[] authorities) {
		super();
		this.name = name;
		this.password = password;
		this.authorities = AuthorityUtils.createAuthorityList(authorities);	} 
	
	public ApplicationUser()
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

	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
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
