package com.apassingment.bumblebee.service;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.apassingment.bumblebee.dao.RegisterDAO;
import com.apassingment.bumblebee.model.User;
import com.apassingment.bumblebee.util.Status;

public class RegisterService extends IdGenImpl{

	private static RegisterService registerService;
	
	public static RegisterService getRegisterService() {
		registerService=new RegisterService();
		return registerService;		
	}
	
	private RegisterDAO getRegisterDAO() {
		return new RegisterDAO();
	}
	
	
	public User RegisterUser(User user) throws ClassNotFoundException, SQLException {
		user.setUserId(getId());
		user.setStatus(Status.ACTIVE.getDatabaseValue());
		user.setUserRole("2");
		user.setRemaingAmount("15,000");
		getRegisterDAO().saveUser(user);
		 return user;
	}

	
}
