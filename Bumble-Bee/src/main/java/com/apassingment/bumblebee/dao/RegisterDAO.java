package com.apassingment.bumblebee.dao;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.apassingment.bumblebee.model.User;

public class RegisterDAO {

	public DbConnector getConnector() {
		DbConnectorFcatory fac =new DbConnectorFactoryImpl();
			return fac.getdbconnection();
	}
	
	private Connection connection() throws ClassNotFoundException, SQLException {
		DbConnector dbconnector =getConnector();
		return dbconnector.getDbConnection();
	}
	
	
	public User saveUser(User user) throws SQLException, ClassNotFoundException {
		
		Connection connection =connection();
		String quray ="INSERT INTO user(user_id,first_name,last_name,user_name,pasword,addres,contact,"
				+ "date_of_birth,user_Role,status,remaing_amount,email) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps=connection.prepareStatement(quray);
		ps.setString(1, user.getUserId());
		ps.setString(2, user.getFirstName());
		ps.setString(3, user.getLastName());
		ps.setString(4, user.getUsername());
		ps.setString(5, user.getPassword());
		ps.setString(6, user.getAddress());
		ps.setString(7, user.getContact());
		ps.setString(8, user.getDob());
		ps.setString(9, user.getUserRole());
//		ps.setString(10, user.getNationalIdentificationNumber());
		ps.setByte(10, user.getStatus());
		ps.setString(11, user.getRemaingAmount());
		ps.setString(12, user.getEmial());
		
		ps.executeUpdate();
		ps.close();
		connection.close();
		
		return user;
		
	}
}
