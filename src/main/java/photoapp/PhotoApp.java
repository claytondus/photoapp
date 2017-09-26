package photoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import photoapp.user.ApplicationUser;
import photoapp.user.UserRepository;

@SpringBootApplication //entry point class
public class PhotoApp {
	
	@Autowired
	private UserRepository userRepository;
	
	public void initializeDB()
	{
		userRepository.deleteAll();
		//default pass is jwtpass
		userRepository.save(new ApplicationUser("Alice","821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a","ROLE_USER"));
		userRepository.save(new ApplicationUser("Bob", "821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a","ROLE_ADMIN,ROLE_USER"));
	}
	
    @Bean
    CommandLineRunner preLoadMongo() throws Exception {
        return args -> {
            initializeDB();
        };
       }
    
    @Bean
    public ShaPasswordEncoder shaPasswordEncoder() {
        return new ShaPasswordEncoder(256);
    }

	public static void main(String[] args) {
						
		//Create Spring application context / search class path / start Tomcat server / default configuration
		SpringApplication.run(PhotoApp.class, args);

	}

}
