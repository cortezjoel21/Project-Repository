package app.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.UserDto;
import app.service.impl.DashboardServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "/registration", description = "Registration", produces = "application/json")
@RequestMapping("/registration")
public class Registration {
	
	private DashboardServiceImpl dsi;
	private HttpHeaders headers = new HttpHeaders();

	public Registration() {
		this.dsi = new DashboardServiceImpl();
		this.headers.add("Content-Type", "application/json");
	}


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
}
