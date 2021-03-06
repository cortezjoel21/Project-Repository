package app.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;

import app.dao.DeletingDocument;
import app.dao.InsertingDocument;
import app.dao.RetrievingDocument;
import app.dao.UpdatingDocument;
import app.dto.UserDto;

@Service("ds")
public class DashboardServiceImpl {

	public Map<BigInteger, UserDto> getUsersMap() {

		Map<BigInteger, UserDto> usersMap = new HashMap<BigInteger, UserDto>();
		UserDto user;

		RetrievingDocument rad = new RetrievingDocument();
		for (Document doc : rad.getTableDataDoc("user")) {
			user = new UserDto();
			user.setId(BigInteger.valueOf(doc.getInteger("id")));
			user.setAccessType(doc.getString("accessType"));
			user.setAccessTypeNo(doc.getString("accessTypeNo"));
			user.setEmail(doc.getString("email"));
			user.setUsername(doc.getString("username"));
			usersMap.put(user.getId(), user);

		}
		return usersMap;
	}

	public Map<BigInteger, UserDto> getUserMap(Integer id) {

		Map<BigInteger, UserDto> userMap = new HashMap<BigInteger, UserDto>();
		UserDto user;

		RetrievingDocument rad = new RetrievingDocument();
		BasicDBObject query = new BasicDBObject();
		query.put("id", id);
		for (Document doc : rad.getRowFromTableDoc("user", query)) {
			user = new UserDto();
			user.setId(BigInteger.valueOf(doc.getInteger("id")));
			user.setAccessType(doc.getString("accessType"));
			user.setAccessTypeNo(doc.getString("accessTypeNo"));
			user.setEmail(doc.getString("email"));
			user.setUsername(doc.getString("username"));
			userMap.put(user.getId(), user);
		}
		return userMap;
	}

	public UserDto getUserAuth() {
		UserDto user = new UserDto();
		user.setUsername("username0");
		user.setPassword("password0");
		user.setAccessType("ADMIN");
		return user;
	}

	public UserDto addUser(UserDto userDto) {
		InsertingDocument id = new InsertingDocument();
		id.addUser(userDto);
		return userDto;
	}

	public UserDto updateUserType(UserDto userDto) {
		UpdatingDocument up = new UpdatingDocument();
		up.updateUser(userDto);
		return userDto;
	}

	public UserDto deleteUser(UserDto userDto) {
		DeletingDocument dd = new DeletingDocument();
		dd.deleteUser(userDto.getId().intValue());
		return userDto;
	}

//	public static void main(String[] args) {
//		DashboardServiceImpl dsi = new DashboardServiceImpl();
//		System.out.println("====: " + dsi.getUserMap());
//	}

}
