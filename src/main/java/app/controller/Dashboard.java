package app.controller;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.dto.UserDto;
import app.service.impl.DashboardServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "/home", description = "Dashboard", produces = "application/json")
@RequestMapping("/dashboard")
public class Dashboard {


	
	private Map<BigInteger, UserDto> userMap;
	private DashboardServiceImpl dsi;
	private HttpHeaders headers = new HttpHeaders();

	/**
	 * Note: Autorization - 403 - jwt
	 * 
	 * 1st - Java - Will Generate Token 2nd - React JS - Pass Token - local storage
	 * 1. Header API 2. On/Off for Header Config for Properties 3rd - Swagger - Pass
	 * Token 4th Description per Methods - Minor
	 */

	public Dashboard() {
		this.dsi = new DashboardServiceImpl();
		this.headers.add("Content-Type", "application/json");
//		this.headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
//		this.headers.add(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.name());
	}

	@ApiOperation(value = "get users", response = UserDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Users Retrieved", response = UserDto.class),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Users not found") })
	@CrossOrigin
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<UserDto>> getUsers() {
		this.userMap = dsi.getUsersMap();
		Collection<UserDto> users = this.userMap.values();
		this.headers.add("Content-Type", "application/json");
		return new ResponseEntity<Collection<UserDto>>(users, this.headers, HttpStatus.OK);
	}

//	@ApiOperation(value = "get user", response = UserDto.class)
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Users Retrieved", response = UserDto.class),
//			@ApiResponse(code = 500, message = "Internal Server Error"),
//			@ApiResponse(code = 404, message = "User not found") })
//	@CrossOrigin
//	@RequestMapping(value="/dashboard/getUser/{id}", method=RequestMethod.GET, 
//			produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Collection<UserDto>> getUser(@PathVariable("id") BigInteger id){
//		this.userMap = dsi.getUserMap(id.intValue());
//		Collection<UserDto> user = this.userMap.values();
//		return new ResponseEntity<Collection<UserDto>>(user, this.headers, HttpStatus.OK);
//	}

	@ApiOperation(value = "register user", response = UserDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User Added", response = UserDto.class),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Users not found") })
	@CrossOrigin
	@PostMapping(value = "/addUser")
	public ResponseEntity addUser(@RequestBody UserDto userDto) {
		HttpHeaders headers = new HttpHeaders();

		this.dsi.addUser(userDto);
		return new ResponseEntity<>(headers, HttpStatus.OK);
	}

	@ApiOperation(value = "update user type", response = UserDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User Updated", response = UserDto.class),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Users not found") })
	@CrossOrigin
	@PostMapping(value = "/updateUser")
	public ResponseEntity updateUserType(@RequestBody UserDto userDto) {
		System.out.println("====userDto: " + userDto.getId());
		this.dsi.updateUserType(userDto);
		return new ResponseEntity<>(this.headers, HttpStatus.OK);
	}

	@ApiOperation(value = "delete user", response = UserDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User Deleted", response = UserDto.class),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Users not found") })
	@CrossOrigin
	@PostMapping(value = "/deleteUser")
	public ResponseEntity deleteUser(@RequestBody UserDto userDto) {
		System.out.println("====userDto: " + userDto.getId());
		this.dsi.deleteUser(userDto);
		return new ResponseEntity<>(this.headers, HttpStatus.OK);
	}

//	@RequestMapping(value = "/logout", method = RequestMethod.POST)
//	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (auth != null) {
//			new SecurityContextLogoutHandler().logout(request, response, auth);
//		}
//		return "redirect:/login";
//	}
}
