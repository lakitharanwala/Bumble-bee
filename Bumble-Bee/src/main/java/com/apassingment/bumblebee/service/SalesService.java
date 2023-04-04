package com.apassingment.bumblebee.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.apassingment.bumblebee.dao.ProductDAO;
import com.apassingment.bumblebee.dao.salesDAO;
import com.apassingment.bumblebee.model.UserHaveProducts;

public class SalesService {
	
	private static SalesService salesService;
	
	public static SalesService getSalesService() {
		salesService=new SalesService();
		return salesService;		
	}
	
	
	private salesDAO getsalesDAO() {
		return new salesDAO();
	}


	public List<UserHaveProducts> getallsales() throws ClassNotFoundException, SQLException {
		return getsalesDAO().getAllsales();
	}


	public List<UserHaveProducts> getSearch(String search) throws ClassNotFoundException, SQLException {
		return getsalesDAO().getSearch(search);
	}
	
}
