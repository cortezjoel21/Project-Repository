package app.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
	public void commence(final HttpServletRequest request, final HttpServletResponse response,
			final AuthenticationException authException) throws IOException, ServletException {
		// Authentication failed, send error response.
		try {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
			PrintWriter writer = response.getWriter();
			writer.println("HTTP Status 401 : " + authException.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		try{
			setRealmName("MY_TEST_REALM");
			super.afterPropertiesSet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}