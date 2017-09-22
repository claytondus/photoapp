package photoapp.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Singleton service that can be injected
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<ApplicationUser> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	public ApplicationUser getUserByName(String name)
	{
		return userRepository.findByName(name);
	}
	
	public void saveUser(ApplicationUser user)
	{
		userRepository.save(user);
	}

}
