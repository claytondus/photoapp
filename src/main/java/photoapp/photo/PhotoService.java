package photoapp.photo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Singleton service that can be injected
@Service
public class PhotoService {
	
	@Autowired
	private PhotoRepository photoRepository;
	
	public List<Photo> getAllPhotos()
	{
		return photoRepository.findAll();
	}
	
	public Photo getUserByName(String title)
	{
		return photoRepository.findByTitle(title);
	}

}
