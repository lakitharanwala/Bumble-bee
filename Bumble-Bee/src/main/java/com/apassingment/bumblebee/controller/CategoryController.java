package com.apassingment.bumblebee.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.apassingment.bumblebee.model.Category;
import com.apassingment.bumblebee.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apassingment.bumblebee.service.CategoryService;

public class CategoryController extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	private CategoryService categoryService; 
	
	public CategoryController() {
		categoryService=CategoryService.getCategoryService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String req=request.getParameter("Catogeroy");
		
		if(id==null&&type==null&&req==null) {
			viewCategoryList(request, response);
		}else if(!(id==null)&& "del".equals(type)) {
			try {
				deleteCategory(request, response, id);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
		}	
		
		if("edit".equals(type)) {
			editCategory(request, response, id);
		}else if (!(req==null)) {
			try {
				categorySearch(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			addCategorys(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private void viewCategoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> categoryList = new ArrayList<Category>();
		try {
			categoryList=categoryService.getallcatorys();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/category-list.jsp");
		rd.forward(request, response);
	}
	
	private void addCategorys(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		Category category =new Category(); 
		category.setCategory(request.getParameter("category"));
		categoryService.savecategory(category);
		response.sendRedirect("category-list");
	}
	
	private void deleteCategory(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		boolean status=categoryService.getdelete(id);
		if(status){  
			request.setAttribute("status", status);
			response.sendRedirect("category-list");
		}  
		else{  
			response.sendRedirect("dashBoard");
		}
		 }
	
	private void editCategory(HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException {
		Category categorydetails = new Category();
		try {
			categorydetails = categoryService.geteditdetails(id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("categorydetails", categorydetails);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/category-list.jsp");
		rd.forward(request, response);
	}
	
	
	private void categorySearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		 
		String categorySearch=request.getParameter("Catogeroy");
		List<Category> categoryList=new ArrayList<Category>();
		categoryList =categoryService.categorySearch(categorySearch);
		 
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/category-list.jsp");
		rd.forward(request, response);
			
	}
	
}
