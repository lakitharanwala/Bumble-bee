package com.apassingment.bumblebee.service;

import java.sql.SQLException;
import java.util.List;

import com.apassingment.bumblebee.dao.RegisterDAO;
import com.apassingment.bumblebee.dao.UserDAO;
import com.apassingment.bumblebee.model.User;

public class UserService {

private static UserService userService;
	
	public static UserService getUserService() {
		userService=new UserService();
		return userService;		
	}
	
	private UserDAO getUserDAO() {
		return new UserDAO();
	}

	public List<User> getUserList() throws ClassNotFoundException, SQLException {
		return getUserDAO().getAllUser();
	}

	
	
}
