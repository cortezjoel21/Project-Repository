package app.dto;

import java.math.BigInteger;

public class User {
	
	public User(Integer id, String name, Integer age, Integer weight) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	private Integer id;
	private String name;
	private String username;
	private String password;
	private Integer age;
	private String email;
	private String accessType;
	private String accessTypeNo;
	private Boolean logIn;
	private String errorMsg;
	private Integer weight;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	
}
