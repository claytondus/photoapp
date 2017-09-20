package photoapp.photo;

import org.springframework.data.mongodb.repository.MongoRepository;

import photoapp.photo.Photo;

//extending the repository gives you CRUD operations
//no need to write mongo queries
public interface PhotoRepository extends MongoRepository<Photo,String> {

	//automatically fills in details of the function for us
	public Photo findByTitle(String title);
	
}
