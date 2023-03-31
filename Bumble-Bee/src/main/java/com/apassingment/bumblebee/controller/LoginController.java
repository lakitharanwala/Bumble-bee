package com.apassingment.bumblebee.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apassingment.bumblebee.dao.DbConnectionImpl;
import com.apassingment.bumblebee.dao.DbConnector;
import com.apassingment.bumblebee.model.User;
import com.apassingment.bumblebee.service.RegisterService;

public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	
		
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		System.out.println(userName);
		System.out.println(password);
		
		DbConnector dbconnector =new DbConnectionImpl();
		
		PreparedStatement ps;
		try {
			ps = dbconnector.getDbConnection().prepareStatement("Select * from user where user_name =? and pasword = ?");
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("user_name"));
			}
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			dbconnector.getDbConnection().close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
}
	
}
