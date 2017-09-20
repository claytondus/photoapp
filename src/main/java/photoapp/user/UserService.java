package photoapp.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Singleton service that can be injected
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	public User getUserByName(String name)
	{
		return userRepository.findByName(name);
	}
	
	public void saveUser(User user)
	{
		userRepository.save(user);
	}

}
