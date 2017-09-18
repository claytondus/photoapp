package photoapp.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired //Needs to be injected
	private UserService userService;
	
	@RequestMapping("/user")
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();	
	}

}
