package com.apassingment.bumblebee.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.spi.RegisterableService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apassingment.bumblebee.dao.DbConnectionImpl;
import com.apassingment.bumblebee.dao.DbConnector;
import com.apassingment.bumblebee.model.User;
import com.apassingment.bumblebee.service.RegisterService;

public class RegisterController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
   private RegisterService registerService; 
	
	public RegisterController() {
		registerService=RegisterService.getRegisterService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		viewRegister(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		registerUser(request, response);
	}	
	
	
	private void viewRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/sign-up.jsp");
		rd.forward(request, response);
	}
	

	private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 User user =new User(); 
	        user.setFirstName(request.getParameter("firstName"));
	        user.setLastName(request.getParameter("lastName"));
	        user.setNationalIdentificationNumber(request.getParameter("nic"));
	        user.setContact(request.getParameter("contact"));
	        user.setAddress(request.getParameter("addres"));
	        user.setEmial(request.getParameter("email"));
	        user.setUsername(request.getParameter("userName"));
	        user.setPassword(request.getParameter("password"));
	        
	       String msg="";
			try {
				registerService.RegisterUser(user);
				msg="user register succsefull"+ user;
				 
			} catch (ClassNotFoundException | SQLException e) {
				msg=e.getMessage();
				e.printStackTrace();
			}
			request.setAttribute("msg", msg);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/user-view.jsp");
			rd.forward(request, response);
			
	}
	
	
	
	
}


