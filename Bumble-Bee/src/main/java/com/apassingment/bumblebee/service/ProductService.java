package com.apassingment.bumblebee.service;

import java.sql.SQLException;
import java.util.List;

import com.apassingment.bumblebee.dao.ProductDAO;
import com.apassingment.bumblebee.model.Brand;
import com.apassingment.bumblebee.model.Products;
import com.apassingment.bumblebee.util.Status;

public class ProductService extends IdGenImpl{

private static ProductService productService;
	
	public static ProductService getProductServiceService() {
		productService=new ProductService();
		return productService;		
	}
	
	private ProductDAO getProductDAO() {
		return new ProductDAO();
	}

	public List<Products> getallProduct() throws ClassNotFoundException, SQLException {
		return getProductDAO().getAllProducts();
	}


	public boolean getdelete(String id) throws ClassNotFoundException, SQLException {
		return getProductDAO().getDeleteProduct(id);
	}

	public List<Products> productSearch(String productSearch) throws ClassNotFoundException, SQLException {
		return getProductDAO().getProductSearch(productSearch);
	}

	public Products saveproducts(Products products) throws ClassNotFoundException, SQLException {
		products.setId(getId());
		products.setStatus(Status.ACTIVE.getDatabaseValue());
		getProductDAO().saveProduct(products);
		return products;
	}

	public Products editproducts(Products products) throws ClassNotFoundException, SQLException {
		return getProductDAO().editProduct(products);
		
	}

}
