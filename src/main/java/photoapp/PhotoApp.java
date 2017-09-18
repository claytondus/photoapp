package photoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //entry point class
public class PhotoApp {

	public static void main(String[] args) {
		
		//Create Spring application context / search class path / start Tomcat server / default configuration
		SpringApplication.run(PhotoApp.class, args);

	}

}
