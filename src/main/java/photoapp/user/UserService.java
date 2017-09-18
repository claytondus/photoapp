package photoapp.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

//Singleton service that can be injected
@Service
public class UserService {
	
	private List<User> users = Arrays.asList(
			new User(123,"user","pass"),
			new User(345,"user2","pass2")
	);
	
	public List<User> getAllUsers()
	{
		return users;
	}

}
