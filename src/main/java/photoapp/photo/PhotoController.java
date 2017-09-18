package photoapp.photo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoController {
	
	@RequestMapping("/photo")
	public String hello() {
		return "Hello from photo controller";
	}

}
