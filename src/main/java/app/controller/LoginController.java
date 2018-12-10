package app.controller;

import java.nio.charset.StandardCharsets;
import java.util.Collection;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import app.dto.UserDto;
import app.service.impl.LoginServiceImpl;
import io.swagger.annotations.Api;

@RestController
public class LoginController {
	private UserDto user = new UserDto();

	@CrossOrigin
	@RequestMapping(value = "/login", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity loginUser(@RequestBody UserDto userDto) {
		LoginServiceImpl ls = new LoginServiceImpl();
		if (!ls.isValidUserAndPassword(userDto.getUsername(), userDto.getPassword())) {
			this.user.setErrorMsg("Invalid username or password");
			System.out.println("this.user.getErrorMsg(): " + this.user.getErrorMsg());
			return userReturn("", "");
		}

		System.out.println("Success: " + ls.getUser().getUsername());
		this.user = ls.getUser();
		return userReturn(userDto.getUsername(), userDto.getPassword());
	}

	private ResponseEntity<UserDto> userReturn(String username, String password) {
		if (username.equals("") || password.equals("")) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		headers.add(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.name());
		String plainClientCredentials = username + ":" + password;
		String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));
		base64ClientCredentials = "Basic " + base64ClientCredentials;
		headers.add("Authorization", base64ClientCredentials);
		this.user.setAuth(base64ClientCredentials);
		return new ResponseEntity<UserDto>(this.user, headers, HttpStatus.OK);
	}
}
