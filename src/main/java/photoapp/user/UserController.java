package photoapp.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired //Needs to be injected
	private UserService userService;
	
	@Autowired
	private ShaPasswordEncoder shaPasswordEncoder;

	@RequestMapping("/")
	public List<ApplicationUser> getAllUsers()
	{
		return userService.getAllUsers();	
	}
	
	@RequestMapping("/{name}")
	public ApplicationUser getUserByName(@PathVariable String name)
	{
		return userService.getUserByName(name);
	}
	
	/*
	 * Store user with encrypted password
	 */
    @RequestMapping("/sign-up/{password}")
    public String signUp(@PathVariable String password) {
    	ApplicationUser user = userService.getUserByName("Bob");
        user.setPassword(shaPasswordEncoder.encodePassword("newpass",""));
        userService.saveUser(user);
        return "successful";
    }

}
