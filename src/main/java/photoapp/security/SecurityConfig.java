package photoapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by nydiarra on 06/05/17.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    static final Integer ENCODING_STRENGTH = 256;

    //Allows auth service to get User data from Mongo
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

	  /*
	  / Sha256 encoding Currently Set for the Authentication Manager
	 */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new ShaPasswordEncoder(ENCODING_STRENGTH));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	//Have to do this for webjars or any folder needs to be accessible 
    	//not logged in
    	//Otherwise it wines about js file having mime type text/html
    	http.authorizeRequests().antMatchers("/webjars/**").permitAll();
    	http.authorizeRequests().antMatchers("/images/**").permitAll();
        http
        .authorizeRequests()
            .antMatchers("/", "/home").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
        .logout()
            .permitAll();
        
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
