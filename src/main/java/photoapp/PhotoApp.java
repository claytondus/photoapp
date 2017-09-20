package photoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import photoapp.user.ApplicationUser;
import photoapp.user.UserRepository;

@SpringBootApplication //entry point class
public class PhotoApp {
	
	@Autowired
	private UserRepository userRepository;
	
	public void initializeDB()
	{
		userRepository.deleteAll();
		userRepository.save(new ApplicationUser("Alice","pass"));
		userRepository.save(new ApplicationUser("Bob","pass"));
	}
	
    @Bean
    CommandLineRunner preLoadMongo() throws Exception {
        return args -> {
            initializeDB();
        };
       }
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

	public static void main(String[] args) {
						
		//Create Spring application context / search class path / start Tomcat server / default configuration
		SpringApplication.run(PhotoApp.class, args);

	}

}
