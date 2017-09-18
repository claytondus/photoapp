package photoapp.user;

import org.springframework.data.mongodb.repository.MongoRepository;

//extending the repository gives you CRUD operations
//no need to write mongo queries
public interface UserRepository extends MongoRepository<User,String> {

	//automatically fills in details of the function for us
	public User findByName(String name);
	
}
