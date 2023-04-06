package com.apassingment.bumblebee.dao;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.apassingment.bumblebee.model.Products;
import com.apassingment.bumblebee.model.User;

public class LoginDAO {

	public DbConnector getConnector() {
		DbConnectorFcatory fac =new DbConnectorFactoryImpl();
			return fac.getdbconnection();
	}
	
	private Connection connection() throws ClassNotFoundException, SQLException {
		DbConnector dbconnector =getConnector();
		return dbconnector.getDbConnection();
	}
	
	
	 
	public boolean validate(String userName,String password) throws ClassNotFoundException, SQLException{
		
		boolean status=false; 
		Connection connection =connection();
		
		String quary="Select * from user where user_name =? and pasword = ? ";
//		PreparedStatement ps=connection.prepareStatement(quary);
//		
//		ps.setString(1, userName);
//		ps.setString(2, password);
//		ps.setString(3, "1");
		
		
		PreparedStatement ps=connection.prepareStatement(quary);
		ps.setString(1, userName);
		ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		User user=new User();
		while(rs.next()){
			
			user.setUsername(userName);
			user.setUserRole(rs.getString("user_role"));
			user.setPassword(password);
			}
		
		if(user.getUserRole().equals("1")) {
			status=true;
		}
		
//		ResultSet rs=ps.executeQuery();  
//		status=rs.next();  
//		
//		if() {
//			
//		}
		
		return status;  
		
	}	
	
	
}



