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

import com.apassingment.bumblebee.model.Brand;
import com.apassingment.bumblebee.model.Category;
import com.apassingment.bumblebee.model.Products;
import com.apassingment.bumblebee.model.User;
import com.apassingment.bumblebee.model.UserHaveProducts;
import com.apassingment.bumblebee.service.BrandService;
import com.apassingment.bumblebee.service.CategoryService;
import com.apassingment.bumblebee.service.ProductService;
import com.apassingment.bumblebee.service.SalesService;
import com.apassingment.bumblebee.service.UserService;

public class SalesController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected SalesService salesService = SalesService.getSalesService();
	protected BrandService brandService = BrandService.getBrandServiceService();
	protected CategoryService categoryService = CategoryService.getCategoryService();
	protected ProductService productService = ProductService.getProductServiceService();
	protected UserService userService = UserService.getUserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String req=request.getParameter("name");
		
		if("edit".equals(type)) {
		}else if (!(req==null)) {
			try {Search(request, response);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				e.printStackTrace();}
		}
		
		if(id==null&&type==null&&req==null) {try {
			viewProductList(request, response);
		}  catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void viewProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		List<Products> viewProductList = new ArrayList<Products>();
		List<User> user = new ArrayList<User>();
		List<UserHaveProducts> uhp = new ArrayList<UserHaveProducts>();
		
		viewProductList=productService.getallProduct();
		user=userService.getUserList();
		uhp=salesService.getallsales();
		
		request.setAttribute("viewProductList", viewProductList);
	    request.setAttribute("user", user);
		request.setAttribute("uhp", uhp);
	
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/sales/sales-tables.jsp");
		rd.forward(request, response);
	}
	
	private void Search(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		String Search=request.getParameter("name");
		List<UserHaveProducts> uhp = new ArrayList<UserHaveProducts>();
		uhp=salesService.getSearch(Search);
		 
		request.setAttribute("uhp", uhp);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/sales/sales-tables.jsp");
		rd.forward(request, response);
		
	}
}
	
