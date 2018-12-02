package app.controller;

import java.nio.charset.StandardCharsets;
import java.util.Collection;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import app.dto.UserDto;
import app.service.impl.LoginServiceImpl;

@Controller
public class LoginController {
	private UserDto user = new UserDto();

//	@CrossOrigin
//	@RequestMapping(value = "/login", method = { RequestMethod.GET,
//			RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<UserDto> loginUsers(@RequestBody String username, @RequestBody String password) {
//		System.out.println("username: " + username);
//		System.out.println("password: " + password);
//		LoginServiceImpl ls = new LoginServiceImpl();
//		if (!ls.isValidUserAndPassword(username, password)) {
//			this.user.setErrorMsg("Invalid username or password");
//			System.out.println("this.user.getErrorMsg(): " + this.user.getErrorMsg());
//			return userReturn();
//		}
//
//		System.out.println("Success: " + ls.getUser().getUsername());
//		this.user = ls.getUser();
//		return userReturn();
//	}
	
		@CrossOrigin
		@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity loginUser(@RequestBody UserDto userDto){
			System.out.println("username: " + userDto.getUsername());
			System.out.println("password: " + userDto.getPassword());
			LoginServiceImpl ls = new LoginServiceImpl();
			if (!ls.isValidUserAndPassword(userDto.getUsername(), userDto.getPassword())) {
				this.user.setErrorMsg("Invalid username or password");
				System.out.println("this.user.getErrorMsg(): " + this.user.getErrorMsg());
				return userReturn();
			}
	
			System.out.println("Success: " + ls.getUser().getUsername());
			this.user = ls.getUser();
			return userReturn();
		}
		
	
//	@CrossOrigin
//	@PostMapping(value="/login")
//	public ResponseEntity loginUser(@RequestBody UserDto userDto){
//		System.out.println("username: " + userDto.getUsername());
//		System.out.println("password: " + userDto.getPassword());
//		LoginServiceImpl ls = new LoginServiceImpl();
//		if (!ls.isValidUserAndPassword(userDto.getUsername(), userDto.getPassword())) {
//			this.user.setErrorMsg("Invalid username or password");
//			System.out.println("this.user.getErrorMsg(): " + this.user.getErrorMsg());
//			return userReturn();
//		}
//
//		System.out.println("Success: " + ls.getUser().getUsername());
//		this.user = ls.getUser();
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", "application/json");
//		return new ResponseEntity<>(headers, HttpStatus.OK);
//	}

	private ResponseEntity<UserDto> userReturn() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		headers.add(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.name());
		return new ResponseEntity<UserDto>(this.user, headers, HttpStatus.OK);
	}

//	@PostMapping("/")
//	public String validateUser(
//			@ModelAttribute("userDto") @Validated UserDto userDto,
//			BindingResult result, 
//			Model model) {
//		
//		if (result.hasErrors()) {
//			return "LoginPage";
//		}
//		
//		model.addAttribute("userDtoSession", userDto);
//		
//		System.out.println("UserDto: " + userDto);
//		
//		LoginServiceImpl ls = (LoginServiceImpl) loginContext.getBean(LoginServiceImpl.class);
//		if (!ls.isValidUserAndPassword(userDto.getUsername(), userDto.getPassword())) {
//			model.addAttribute("error", "Invalid password");
//			return "LoginPage";
//		}
//		
//		return "redirect:/dashboard";
//	}
}
