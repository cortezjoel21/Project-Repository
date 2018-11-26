package app.dao;

import org.json.JSONArray;

public class LoginDao {
	
	public JSONArray getUsersPasswords() {
		String usersJsonStr = ""; 
		JSONArray jsonArray = null;
		try {
			usersJsonStr = 
					"[" +
					"  {" +
					"    \"username\": \"admin1\"," +
					"    \"password\": \"password1\"" +
					"  }," +
					"  {" +
					"    \"username\": \"admin2\"," +
					"    \"password\": \"password2\"" +
					"  }" +
					"]";
			
			jsonArray = new JSONArray(usersJsonStr);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return jsonArray;
	}
}
