package com.cloud.project.tweetmap.model.user;

import com.cloud.project.tweetmap.dao.user.UserDao;

public class UserModel {

	public boolean checkLogin(String userName, String password) {
		
		UserDao objDAO = new UserDao();
		
		boolean loginResult = objDAO.checkLogin(userName, password);
		
		return loginResult;
		
	}

}
