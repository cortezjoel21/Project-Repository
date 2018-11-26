package app.service.impl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import app.dao.LoginDao;

@Service("ls")
public class LoginServiceImpl {
	
	public boolean isValidUserAndPassword(String username, String password) {
		boolean isValidAndPassword = false;
		LoginDao loginDao = new LoginDao();
		
		JSONArray usersJsonArr = loginDao.getUsersPasswords();
		
		JSONObject jsonObj = null;
		String usernameFromJson = null;
		String passwordFromJson = null;
		for (int i = 0; i < usersJsonArr.length(); i++) {
			try {
				jsonObj = usersJsonArr.getJSONObject(i);
				usernameFromJson = jsonObj.getString("username");
				passwordFromJson = jsonObj.getString("password");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			if (username.equalsIgnoreCase(usernameFromJson) && password.equals(passwordFromJson)) {
				isValidAndPassword = true;
			}
		}
		
		return isValidAndPassword;
	}

}
