package com.apassingment.bumblebee.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.apassingment.bumblebee.model.User;
import com.apassingment.bumblebee.service.BrandService;

public class BrandController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private BrandService brandService; 
	public BrandController() {
		brandService=BrandService.getBrandServiceService();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String req=request.getParameter("name");
		
		if(id==null&&type==null&&req==null) {
			viewBrandList(request, response);
		}else if(!(id==null)&& "del".equals(type)) {
			try {
				deleteBrand(request, response, id);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				e.printStackTrace();
			}
		}	
		
		if("edit".equals(type)) {
			//editBrand(request, response, id);
		}else if (!(req==null)) {
			try {
				barandSearch(request, response);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				e.printStackTrace();
			}
		}
		
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String type = request.getParameter("type");
		
		
		if("edit".equals(type)) {
			try {
				editBrand(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				e.printStackTrace();
			 }
		}else {
			try {
				addBrands(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				e.printStackTrace();
			 }
		}
		
		
	}
	
	private void viewBrandList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Brand> brandList = new ArrayList<Brand>();
		try {
			brandList=brandService.getallBrands();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("brandList", brandList);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/brands/brand-list.jsp");
		rd.forward(request, response);
	}
	
	private void addBrands(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		Brand brand =new Brand(); 
		brand.setName(request.getParameter("name"));
		brandService.saveBrand(brand);
		response.sendRedirect("brands-list");
	}
	
	private void deleteBrand(HttpServletRequest request, HttpServletResponse response, String id) throws ClassNotFoundException, SQLException, IOException {
		boolean status=brandService.getdelete(id);
		if(status){  
			request.setAttribute("status", status);
			response.sendRedirect("brands-list");
		}  
		else{  
			response.sendRedirect("dashBoard");
		}
	}
	
	private void barandSearch(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		String barndSearch=request.getParameter("name");
		List<Brand> brandList=new ArrayList<Brand>();
		brandList =brandService.brandSearch(barndSearch);
		 
		request.setAttribute("brandList", brandList);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/brands/brand-list.jsp");
		rd.forward(request, response);
		
	}


	private void editBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		Brand brand =new Brand(); 
		brand.setId(request.getParameter("Id"));
		brand.setName(request.getParameter("name"));
		brandService.SaveEdit(brand);
		response.sendRedirect("brands-list");
	
	}


	
	
}
