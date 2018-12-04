package app.controller;

import java.math.BigInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.config.SwaggerConfig;
import app.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "/users", description = "User Profile", produces = "application/json")
@RequestMapping("/users")
public class UsersController {
	
	
	@ApiOperation(value = "get users", response = UserDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Users Retrieved", response = UserDto.class),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Users not found") })
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<UserDto> getCustomer() {
		UserDto user = new UserDto();
		user.setUsername("username0");
		user.setId(BigInteger.valueOf(0));
		user.setEmail("email0");
		return new ResponseEntity<UserDto>(user, HttpStatus.OK);
	}
}