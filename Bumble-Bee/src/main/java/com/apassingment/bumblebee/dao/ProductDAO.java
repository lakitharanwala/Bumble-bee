package com.apassingment.bumblebee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.apassingment.bumblebee.model.Brand;
import com.apassingment.bumblebee.model.Products;

public class ProductDAO {
	public DbConnector getConnector() {
		DbConnectorFcatory fac =new DbConnectorFactoryImpl();
			return fac.getdbconnection();
	}
	
	private Connection connection() throws ClassNotFoundException, SQLException {
		DbConnector dbconnector =getConnector();
		return dbconnector.getDbConnection();
	}
	
	public List<Products> getAllProducts() throws ClassNotFoundException, SQLException {
		Connection connection =connection();
		String quray ="SELECT * FROM products WHERE status = 0 ";
		String categoryName ="SELECT * FROM categorys WHERE id =? ";
		String brandName ="SELECT * FROM brand WHERE id =? ";
		
		Statement st= connection.createStatement();
		ResultSet rs=st.executeQuery(quray);
		
		List<Products>productsList=new ArrayList<Products>();
		
		while(rs.next()){
			Products products=new Products();
			products.setName(rs.getString("name"));
			products.setStatus(rs.getByte("status"));
			products.setId(rs.getString("id"));
			products.setPrice(rs.getString("price"));
			products.setCategoryId(rs.getString("category_Id"));
			products.setBrand(rs.getString("brand_Id"));
			products.setQuantity(rs.getString("quantity"));
			
			PreparedStatement prep=connection.prepareStatement(categoryName);
			prep.setString(1, rs.getString("category_Id"));
			ResultSet rws=prep.executeQuery();
			
			while(rws.next()){
				products.setCategoryName(rws.getString("CATEGORYE"));
			}
			
			PreparedStatement pre=connection.prepareStatement(brandName);
			pre.setString(1, rs.getString("brand_Id"));
			ResultSet res=pre.executeQuery();
			
			while(res.next()){
				products.setBrandName(res.getString("NAME"));
			}
			
			productsList.add(products);
		}
		
		
		
		st.close();
		connection.close();
		return productsList;
	}

	public boolean getDeleteProduct(String id) throws ClassNotFoundException, SQLException {
Connection connection =connection();
		
		String quray ="UPDATE products SET status = 1 WHERE Id=? ";
		PreparedStatement ps=connection.prepareStatement(quray);
		ps.setString(1, id);
		
		boolean status=false;
		ps.executeUpdate(); 
		  

		return status=true;
	}

	public List<Products> getProductSearch(String productSearch) throws ClassNotFoundException, SQLException {
		Connection connection =connection();
		String quray ="SELECT * FROM products WHERE name=?";
		String categoryName ="SELECT * FROM categorys WHERE id =? ";
		String brandName ="SELECT * FROM brand WHERE id =? ";
		
		PreparedStatement ps=connection.prepareStatement(quray);
		ps.setString(1, productSearch);
		ResultSet rs=ps.executeQuery();
		
		List<Products>productsList=new ArrayList<Products>();
	
		while(rs.next()){
			Products products=new Products();
			products.setName(rs.getString("name"));
			products.setStatus(rs.getByte("status"));
			products.setId(rs.getString("id"));
			products.setPrice(rs.getString("price"));
			products.setCategoryId(rs.getString("category_Id"));
			products.setBrand(rs.getString("brand_Id"));
			
			PreparedStatement prep=connection.prepareStatement(categoryName);
			prep.setString(1, rs.getString("category_Id"));
			ResultSet rws=prep.executeQuery();
			
			while(rws.next()){
				products.setCategoryName(rws.getString("CATEGORYE"));
			}
			
			PreparedStatement pre=connection.prepareStatement(brandName);
			pre.setString(1, rs.getString("brand_Id"));
			ResultSet res=pre.executeQuery();
			
			while(res.next()){
				products.setBrandName(res.getString("NAME"));
			}
			
			productsList.add(products);
		}
		ps.close();
		connection.close();
		return productsList;
	}

	public Products saveProduct(Products products) throws ClassNotFoundException, SQLException {
		Connection connection =connection();
		String quray ="INSERT INTO products(Id,name,status,category_Id,price,brand_id,quantity)"
				+ "VALUES (?,?,?,?,?,?,?)";
		String categoryName ="SELECT * FROM categorys WHERE CATEGORYE =? ";
		String brandName ="SELECT * FROM brand WHERE name =? ";
		
		String can=products.getCategoryName();
		String brn=products.getBrandName();
		
		PreparedStatement prep=connection.prepareStatement(categoryName);
		prep.setString(1, can);
		ResultSet rws=prep.executeQuery();
		
		while(rws.next()) {
			products.setCategoryId(rws.getString("id"));
		}
		
		PreparedStatement pre=connection.prepareStatement(brandName);
		pre.setString(1, brn);
		ResultSet res=pre.executeQuery();
		
		while(res.next()) {
			products.setBrand(res.getString("id"));
		}
		
		
		PreparedStatement ps=connection.prepareStatement(quray);
		ps.setString(1, products.getId());
		ps.setString(2, products.getName());
		ps.setByte(3, products.getStatus());
		ps.setString(4, products.getCategoryId());
		ps.setString(5, products.getPrice());
		ps.setString(6, products.getBrand());
		ps.setString(7, products.getQuantity());
		
		ps.executeUpdate();
		ps.close();
		connection.close();
		return products;
	}
	
	
}
