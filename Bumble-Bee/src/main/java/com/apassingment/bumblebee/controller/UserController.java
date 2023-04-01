package com.apassingment.bumblebee.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apassingment.bumblebee.model.User;
import com.apassingment.bumblebee.service.UserService;

public class UserController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private UserService userService; 
	
	public UserController() {
		userService=UserService.getUserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		viewUserList(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
	}	
	
	private void viewUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> UserList = new ArrayList<User>();;
		try {
			UserList = userService.getUserList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("userList", UserList);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/user-List.jsp");
		rd.forward(request, response);
	}
	
}










