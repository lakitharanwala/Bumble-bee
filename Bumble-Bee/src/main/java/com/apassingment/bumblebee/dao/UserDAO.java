package com.apassingment.bumblebee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.apassingment.bumblebee.model.User;
import com.apassingment.bumblebee.util.Status;

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
			user.setStatus(rs.getByte("status"));
			
			
			
			userList.add(user);
		}
		
		st.close();
		connection.close();
		return userList;

	}

	public boolean getdeleteUser(String id) throws ClassNotFoundException, SQLException {
		Connection connection =connection();
		
		String quray ="UPDATE user SET status = 1 WHERE user_Id=? ";
		PreparedStatement ps=connection.prepareStatement(quray);
		ps.setString(1, id);
		
		boolean status=false;
		ps.executeUpdate(); 
		  

		return status=true;
	}

	public User getEditUserDetails(String id) throws ClassNotFoundException, SQLException {
		Connection connection =connection();
		String quray ="SELECT * FROM user WHERE user_Id=?";
		
		PreparedStatement ps=connection.prepareStatement(quray);
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()){
			    rs.getString(1);
			}

		List<User>userDeails=new ArrayList<User>();
		
			User user=new User();
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setUsername(rs.getString("user_name"));
			user.setAddress(rs.getString("addres"));
			user.setContact(rs.getString("contact"));
			user.setUserId(rs.getString("user_id"));
			user.setRemaingAmount(rs.getString("remaing_amount"));
			user.setEmial(rs.getString("email"));
			
		
		ps.close();
		connection.close();
		return user;
	}

	public User getSaveEditUserDetails(User user) throws ClassNotFoundException, SQLException {
		String id=user.getUserId();
		Connection connection =connection();
		
		String quray="UPDATE user SET first_Name=?,last_name=?,user_name=?,addres=?,contact=?,email=? WHERE user_id = ?";
		
		PreparedStatement ps=connection.prepareStatement(quray);
		ps.setString(1, user.getFirstName());
		ps.setString(2, user.getLastName());
		ps.setString(3, user.getUsername());
		ps.setString(4, user.getAddress());
		ps.setString(5, user.getContact());
		ps.setString(6, user.getEmial());
		ps.setString(7, id);
		
		ps.executeUpdate(); 
		
		
		return null;
	}

	public List<User> getUserSearch(String userSearch) throws ClassNotFoundException, SQLException {
		Connection connection =connection();
		String quray ="SELECT * FROM user WHERE user_name=?";
		
		PreparedStatement ps=connection.prepareStatement(quray);
		ps.setString(1, userSearch);
		ResultSet rs=ps.executeQuery();
		
		

		List<User>userDeails=new ArrayList<User>();
		
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
			user.setStatus(rs.getByte("status"));
			userDeails.add(user);
		}
		ps.close();
		connection.close();
		return userDeails;
	}
	
}
