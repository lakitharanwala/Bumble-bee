package com.apassingment.bumblebee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionImpl implements DbConnector{

	public Connection getDbConnection() throws ClassNotFoundException, SQLException {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  String url = "jdbc:mysql://localhost:3306/bumble_bee";
		  String userName = "root";
		  String pw ="root";
		  
		  Connection connection=DriverManager.getConnection(url, userName, pw);
		  return connection;
	}

	

}
