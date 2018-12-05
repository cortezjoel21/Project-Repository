//package app.service.jwt;
//
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//
//import app.service.impl.CustomAccessTokenConverter;
//
//@Configuration
//@EnableResourceServer
//public class OAuth2ResourceServerConfigJwt
// extends ResourceServerConfigurerAdapter {
// 
//    @Autowired
//    private CustomAccessTokenConverter customAccessTokenConverter;
// 
//    @Bean
//    public TokenStore tokenStore() {
//        return new JwtTokenStore(accessTokenConverter());
//    }
// 
//    @Bean
//    public JwtAccessTokenConverter accessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setAccessTokenConverter(customAccessTokenConverter);
//		return converter;
//    }
//    
//    public Map<String, Object> getExtraInfo(Authentication auth) {
//        OAuth2AuthenticationDetails oauthDetails
//          = (OAuth2AuthenticationDetails) auth.getDetails();
//        return (Map<String, Object>) oauthDetails.getDecodedDetails();
//    }
//}
