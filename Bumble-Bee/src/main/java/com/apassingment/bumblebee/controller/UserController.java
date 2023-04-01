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
		
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String req=request.getParameter("userName");
		
		if(id==null&&type==null&&req==null) {
			viewUserList(request, response);
		}else if(!(id==null)&& "del".equals(type)) {
			try {
				deleteUser(request, response,id);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		if("edit".equals(type)) {
			editUser(request, response,id);
		}else if (!(req==null)) {
			userSearch(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       saveEditUser(request, response);
	}	
	
	private void viewUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> UserList = new ArrayList<User>();;
		try {
			UserList = userService.getUserList();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("userList", UserList);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/user-List.jsp");
		rd.forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		boolean status=userService.getdelete(id);
		if(status){  
			request.setAttribute("status", status);
			response.sendRedirect("user-List");
		}  
		else{  
			response.sendRedirect("dashBoard");
		}
		
			}
	
	private void editUser(HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException {
		User Userdetails = new User();
		try {
			Userdetails = userService.geteditUser(id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("userdetails", Userdetails);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/user-edit.jsp");
		rd.forward(request, response);
	}
	
	private void saveEditUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 User user =new User(); 
		 	user.setUserId(request.getParameter("userId"));
	        user.setFirstName(request.getParameter("firstName"));
	        user.setLastName(request.getParameter("lastName"));
	        user.setContact(request.getParameter("contact"));
	        user.setAddress(request.getParameter("addres"));
	        user.setEmial(request.getParameter("email"));
	        user.setUsername(request.getParameter("userName"));
	        
	        String msg="";
			try {
				userService.SaveEditUser(user);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("user-List");
			
	}
	
	
	private void userSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String userSearch=request.getParameter("userName");
		List<User> UserList=new ArrayList<User>();
		try {
			UserList =userService.UserSearch(userSearch);
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










