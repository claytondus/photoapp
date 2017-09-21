package photoapp.photo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoController {
	
	@RequestMapping("/photo")
	@PreAuthorize("hasAuthority('admin')")
	public String hello() {
		return "Hello from photo controller";
	}

}
