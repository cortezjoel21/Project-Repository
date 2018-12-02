package app.dto;

import java.math.BigInteger;

public class UserDto {
	private BigInteger id;
	private String username;
	private String password;
	private String email;
	private String accessType;
	private String accessTypeNo;
	private Boolean logIn;
	private String errorMsg;
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccessType() {
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}
	public String getAccessTypeNo() {
		return accessTypeNo;
	}
	public void setAccessTypeNo(String accessTypeNo) {
		this.accessTypeNo = accessTypeNo;
	}
	public Boolean getLogIn() {
		return logIn;
	}
	public void setLogIn(Boolean logIn) {
		this.logIn = logIn;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
