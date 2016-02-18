package com.tdt.aws.service;

import org.json.JSONObject;

import com.tdt.aws.dao.UserDao;
import com.tdt.aws.model.User;


public class DynamodbService {

	private UserDao userDao  = new UserDao();
	
	public boolean checkLogin(String email, String password) {
		
		//get JSON object from DB
		JSONObject jsonObject = userDao.getJSONByEmail(email);
		//get JSON propety
		Object pwd = jsonObject.get("password");
		return pwd == null ? false : pwd.equals(password) ? true : false;
	}
	public User save(String jsonString) throws Exception {
		return userDao.save(jsonString);
	}
}
