package app.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig implements  WebMvcConfigurer {

//	final private String AUTH_SERVER = "http://localhost:8080";
//	final private String CLIENT_ID = "Joel";
//	final private String CLIENT_SECRET = "Passowrd";
//	
//	@Bean
//	public Docket api() {
//	    return new Docket(DocumentationType.SWAGGER_2).select()
//	        .apis(RequestHandlerSelectors.any())
//	        .paths(PathSelectors.any())
//	        .build()
//	        .securitySchemes(Arrays.asList(securityScheme()))
//	        .securityContexts(Arrays.asList(securityContext()));
//	}
//	
//	private ApiInfo apiInfo() {
//	    return new ApiInfo(
//	      "My REST API", 
//	      "Some custom description of API.", 
//	      "API TOS", 
//	      "Terms of service", 
//	      new Contact("John Doe", "www.example.com", "myeaddress@company.com"), 
//	      "License of API", "API license URL", Collections.emptyList());
//	}
//	
//	public SecurityConfiguration security() {
//	    return SecurityConfigurationBuilder.builder()
//	        .clientId(CLIENT_ID)
//	        .clientSecret(CLIENT_SECRET)
//	        .scopeSeparator(" ")
//	        .useBasicAuthenticationWithAccessCodeGrant(true)
//	        .build();
//	}
//	
//	private SecurityContext securityContext() {
//	    return SecurityContext.builder()
//	      .securityReferences(
//	        Arrays.asList(new SecurityReference("spring_oauth", scopes())))
//	      .forPaths(PathSelectors.regex("/foos.*"))
//	      .build();
//	}
//	
//	private SecurityScheme securityScheme() {
//	    GrantType grantType = new AuthorizationCodeGrantBuilder()
//	        .tokenEndpoint(new TokenEndpoint(AUTH_SERVER + "/token", "oauthtoken"))
//	        .tokenRequestEndpoint(
//	          new TokenRequestEndpoint(AUTH_SERVER + "/authorize", CLIENT_ID, CLIENT_ID))
//	        .build();
//	 
//	    SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
//	        .grantTypes(Arrays.asList(grantType))
//	        .scopes(Arrays.asList(scopes()))
//	        .build();
//	    return oauth;
//	}
//	
//	private AuthorizationScope[] scopes() {
//	    AuthorizationScope[] scopes = { 
//	      new AuthorizationScope("read", "for read operations"), 
//	      new AuthorizationScope("write", "for write operations"), 
//	      new AuthorizationScope("foo", "Access foo API") };
//	    return scopes;
//	}
}
