package com.apassingment.bumblebee.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apassingment.bumblebee.dao.DbConnectionImpl;
import com.apassingment.bumblebee.dao.DbConnector;
import com.apassingment.bumblebee.model.User;
import com.apassingment.bumblebee.service.LoginService;
import com.apassingment.bumblebee.service.RegisterService;


public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService; 
	
	public LoginController() {
		loginService=LoginService.getLoginService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		login(request, response);
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
	      HashMap<String, String> userDetails = new HashMap<String, String>();
	      userDetails.put("firstName", userName);
	      userDetails.put("lastName", password);
	      
	      HttpSession session = request.getSession();
	      session.setAttribute("user", userDetails);
	      
		
		try {
			if(loginService.validate(userName,password)){  
				
				String msg="";
				request.setAttribute("msg", msg);
				response.sendRedirect("dashBoard");
			}  
			else{  
				String msg="password or user name is not valid";
				request.setAttribute("msg", msg);
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/sign-in.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
}
