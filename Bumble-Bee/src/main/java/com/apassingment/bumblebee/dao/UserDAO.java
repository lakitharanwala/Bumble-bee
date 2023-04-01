package com.apassingment.bumblebee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.apassingment.bumblebee.model.User;

public class UserDAO {

	public DbConnector getConnector() {
		DbConnectorFcatory fac =new DbConnectorFactoryImpl();
			return fac.getdbconnection();
	}
	
	private Connection connection() throws ClassNotFoundException, SQLException {
		DbConnector dbconnector =getConnector();
		return dbconnector.getDbConnection();
	}

	public List<User> getAllUser() throws ClassNotFoundException, SQLException {
		Connection connection =connection();
		String quray ="SELECT * FROM user WHERE user_role = 2 and status = 0 ";
		
		Statement st= connection.createStatement();
		ResultSet rs=st.executeQuery(quray);
		
		List<User>userList=new ArrayList<User>();
		
		while(rs.next()){
			User user=new User();
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setUsername(rs.getString("user_name"));
			user.setAddress(rs.getString("addres"));
			user.setContact(rs.getString("contact"));
			user.setUserId(rs.getString("user_id"));
			user.setRemaingAmount(rs.getString("remaing_amount"));
			user.setEmial(rs.getString("email"));
			
			userList.add(user);
		}
		
		st.close();
		connection.close();
		return userList;

	}
	
}
