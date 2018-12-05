package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import app.dto.UserDto;
import app.service.impl.DashboardServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static String REALM = "MY_TEST_REALM";
	private UserDto user = new UserDto();
	
	public SecurityConfiguration() {
		DashboardServiceImpl dsi = new DashboardServiceImpl();
		this.user = dsi.getUserAuth();
	}
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//		String passEcyrpted = new BCryptPasswordEncoder().encode("abc123");
//		System.out.println("passEcyrpted: " + passEcyrpted);
		auth.inMemoryAuthentication().withUser(this.user.getUsername()).password("{noop}" + this.user.getPassword()).roles(this.user.getAccessType().toUpperCase());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		try {
			http.csrf().disable().authorizeRequests().antMatchers("/dashboard/**").hasRole("ADMIN").and()
					.httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint()).and()
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			// We don't need sessions to be created.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Bean
	public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
		return new CustomBasicAuthenticationEntryPoint();
	}

	/* To allow Pre-flight [OPTIONS] request from browser */
	@Override
	public void configure(WebSecurity web) throws Exception {
		try {
			web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
						.allowedHeaders("*");
			}
		};
	}
	
	
//
//	@Bean
//	public BCryptPasswordEncoder encoder() {
//		return new BCryptPasswordEncoder(4);
//	}
		
}