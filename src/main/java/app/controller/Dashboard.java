package app.controller;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.dto.UserDto;
import app.service.impl.DashboardServiceImpl;

@Controller
public class Dashboard {

	private Map<BigInteger, UserDto> userMap;
	private DashboardServiceImpl dsi;
	private HttpHeaders headers = new HttpHeaders();
	
	public Dashboard() {
		 this.dsi  = new DashboardServiceImpl();
		 this.headers.add("Content-Type", "application/json");
		 this.headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		 this.headers.add(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.name());
	}

	@CrossOrigin
	@RequestMapping(value="/dashboard/getUsers", method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<UserDto>> getUsers(){
		this.userMap = dsi.getUsersMap();
		Collection<UserDto> users = this.userMap.values();
		return new ResponseEntity<Collection<UserDto>>(users, this.headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/dashboard/getUser/{id}", method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<UserDto>> getUser(@PathVariable("id") BigInteger id){
		this.userMap = dsi.getUserMap(id.intValue());
		Collection<UserDto> user = this.userMap.values();
		return new ResponseEntity<Collection<UserDto>>(user, this.headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping(value="/dashboard/addUser")
	public ResponseEntity addUser(@RequestBody UserDto userDto){
		HttpHeaders headers = new HttpHeaders();
		
	    this.dsi.addUser(userDto);
		return new ResponseEntity<>(headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping(value="/dashboard/updateUser")
	public ResponseEntity updateUser(@RequestBody UserDto userDto){
		System.out.println("====userDto: " + userDto.getId());
	    this.dsi.updateUser(userDto);
		return new ResponseEntity<>(this.headers, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping(value="/dashboard/deleteUser")
	public ResponseEntity deleteUser(@RequestBody UserDto userDto){
		System.out.println("====userDto: " + userDto.getId());
	    this.dsi.deleteUser(userDto);
		return new ResponseEntity<>(this.headers, HttpStatus.OK);
	}
}
