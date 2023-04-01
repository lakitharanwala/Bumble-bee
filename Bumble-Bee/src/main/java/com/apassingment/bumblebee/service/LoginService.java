package com.apassingment.bumblebee.service;

import java.sql.SQLException;

import com.apassingment.bumblebee.dao.LoginDAO;


public class LoginService {

private static LoginService loginService;
	
	public static LoginService getLoginService() {
		loginService=new LoginService();
		return loginService;		
	}
	
	private LoginDAO getLoginDAO() {
		return new LoginDAO();
	}

	public boolean validate(String userName, String password) throws ClassNotFoundException, SQLException {
		return getLoginDAO().validate(userName, password);
		
	}
	
}
