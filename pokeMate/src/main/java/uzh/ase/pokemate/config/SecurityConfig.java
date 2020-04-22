package uzh.ase.pokemate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication()//
				.withUser("pokeUser").password("MateEmAll").authorities("ROLE_USER")//
				.and().withUser("pokeAdmin").password("MateEmAll2").authorities("ROLE_USER", "ROLE_ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Needed for Cross Origin Requests!!
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/homePage").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
				.antMatchers("/userPage").access("hasRole('ROLE_USER')").antMatchers("/adminPage")
				.access("hasRole('ROLE_ADMIN')").and().formLogin()// .loginPage("/loginPage")
				.defaultSuccessUrl("/homePage").failureUrl("/loginPage?error").usernameParameter("username")
				.passwordParameter("password").and().logout().logoutSuccessUrl("/loginPage?logout");

	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
