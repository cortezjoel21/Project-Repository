package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {

	private static String REALM = "MY_TEST_REALM";

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("tom").password("abc123").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		try {
			http.csrf().disable().authorizeRequests().antMatchers("/user/**").hasRole("ADMIN").and().httpBasic()
					.realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint()).and().sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
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
}