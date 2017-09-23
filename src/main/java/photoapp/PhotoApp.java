package photoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

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
    @Description("Thymeleaf Template Resolver")
    public ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
     
        return templateResolver;
    }
    
    @Bean
    @Description("Spring Message Resolver")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
    
    @Bean
    @Description("Thymeleaf Template Engine")
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setTemplateEngineMessageSource(messageSource());
        return templateEngine;
    }
    
    @Bean
    @Description("Thymeleaf View Resolver")
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setOrder(1);
        return viewResolver;
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
