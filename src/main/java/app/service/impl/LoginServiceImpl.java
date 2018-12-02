package app.service.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;

import app.dao.RetrievingDocument;
import app.dto.UserDto;

@Service("ls")
public class LoginServiceImpl {
	
	private UserDto user = new UserDto();
	
	public boolean isValidUserAndPassword(String username, String password) {
		boolean isValidAndPassword = false;
		Object userObj = getUser(username, password);
		if(userObj == null) {
			setInvalidUser();
		}else {
			this.user = (UserDto) userObj;
			System.out.println("this.user: " + this.user.getPassword());
			System.out.println("password: " + password);
			if(this.user.getPassword().toString().equals(password.toString())) {
				isValidAndPassword = true;
				this.user.setLogIn(true);
				this.user.setPassword("");
			}else {
				setInvalidUser();
			}
		}
		System.out.println("this.user.getLogIn(): " + this.user.getLogIn());
		return isValidAndPassword;
	}
	
	private void setInvalidUser() {
		this.user = new UserDto();
		this.user.setLogIn(false);
		this.user.setErrorMsg("Invalid username or password");
	}

	public UserDto getUser(String username, String password) {
		UserDto user = new UserDto();
		
		RetrievingDocument rad = new RetrievingDocument();
		BasicDBObject query = new BasicDBObject();
		query.put("username", username);
		for (Document doc : rad.getRowFromTableDoc("user", query)) {
			user.setId(BigInteger.valueOf(doc.getInteger("id")));
			user.setAccessType(doc.getString("accessType"));
			user.setAccessTypeNo(doc.getString("accessTypeNo"));
			user.setEmail(doc.getString("email"));
			user.setUsername(doc.getString("username"));
			user.setPassword(doc.getString("password"));
			System.out.println("====user: " + user.getUsername());
		}
		return user;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
	
	
}
