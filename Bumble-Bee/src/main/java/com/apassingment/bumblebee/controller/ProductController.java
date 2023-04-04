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
import com.apassingment.bumblebee.service.BrandService;
import com.apassingment.bumblebee.service.CategoryService;
import com.apassingment.bumblebee.service.ProductService;

public class ProductController extends HttpServlet{

private static final long serialVersionUID = 1L;
	
	private ProductService productService; 
	public ProductController() {
		productService=ProductService.getProductServiceService();
	}
	
	protected BrandService brandService = BrandService.getBrandServiceService();
	
	protected CategoryService categoryService = CategoryService.getCategoryService();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String req=request.getParameter("name");
		
		if(id==null&&type==null&&req==null) {
			try {
				viewProductList(request, response);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				e.printStackTrace();
			}
		}else if(!(id==null)&& "del".equals(type)) {
			try {
				deleteproduct(request, response, id);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				e.printStackTrace();
			}
		}	
		
		if("edit".equals(type)) {
			//editBrand(request, response, id);
		}else if (!(req==null)) {
			try {
				productSearch(request, response);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			save(request, response);
		}  catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		Products products =new Products(); 
		products.setName(request.getParameter("name"));
		products.setBrandName(request.getParameter("brand"));
		products.setCategoryName(request.getParameter("category"));
		products.setPrice(request.getParameter("price"));
		products.setQuantity(request.getParameter("quantity"));
		productService.saveproducts(products);
		response.sendRedirect("product-list");
	}

	private void viewProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		List<Products> viewProductList = new ArrayList<Products>();
		List<Brand> brand = new ArrayList<Brand>();
		List<Category> cate = new ArrayList<Category>();
		
		viewProductList=productService.getallProduct();
		brand=brandService.getallBrands();
		cate=categoryService.getallcatorys();
		
		request.setAttribute("viewProductList", viewProductList);
	    request.setAttribute("brand", brand);
		request.setAttribute("cate", cate);
	
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/products/product-list.jsp");
		rd.forward(request, response);
	}
	
	
	private void deleteproduct(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, ClassNotFoundException, SQLException, IOException {
		boolean status=productService.getdelete(id);
		if(status){  
			request.setAttribute("status", status);
			response.sendRedirect("delete-product");
		}  
		else{  
			response.sendRedirect("dashBoard");
		}
	}
	
	private void productSearch(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		String productSearch=request.getParameter("name");
		List<Products> viewProductList=new ArrayList<Products>();
		viewProductList =productService.productSearch(productSearch);
		 
		request.setAttribute("viewProductList", viewProductList);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/pages/products/product-list.jsp");
		rd.forward(request, response);
		
	}
	
}
