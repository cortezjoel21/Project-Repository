//package app.service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.token.TokenEnhancer;
//import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
//
//public class CustomTokenEnhancer implements TokenEnhancer {
//	@Override
//	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//		Map<String, Object> additionalInfo = new HashMap<String, Object>();
//		additionalInfo.put("organization", authentication.getName() + randomAlphabetic(4));
//		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
//		return accessToken;
//	}
//}