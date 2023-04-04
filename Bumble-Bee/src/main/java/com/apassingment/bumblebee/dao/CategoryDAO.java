package com.apassingment.bumblebee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.apassingment.bumblebee.model.Category;
import com.apassingment.bumblebee.model.User;


public class CategoryDAO {
	
	public DbConnector getConnector() {
		DbConnectorFcatory fac =new DbConnectorFactoryImpl();
			return fac.getdbconnection();
	}
	
	private Connection connection() throws ClassNotFoundException, SQLException {
		DbConnector dbconnector =getConnector();
		return dbconnector.getDbConnection();
	}

	public List<Category> getAllCategorys() throws ClassNotFoundException, SQLException {
		Connection connection =connection();
		String quray ="SELECT * FROM categorys WHERE status = 0 ";
		
		Statement st= connection.createStatement();
		ResultSet rs=st.executeQuery(quray);
		
		List<Category>categoryList=new ArrayList<Category>();
		
		while(rs.next()){
			Category category=new Category();
			category.setCategory(rs.getString("CATEGORYE"));
			category.setStatus(rs.getByte("status"));
			category.setId(rs.getString("id"));
			categoryList.add(category);
		}
			
		st.close();
		connection.close();
		return categoryList;
	}

	public Category saveCategory(Category category) throws ClassNotFoundException, SQLException {
		Connection connection =connection();
		String quray ="INSERT INTO categorys(Id,categorye,status)"
				+ "VALUES (?,?,?)";
		
		PreparedStatement ps=connection.prepareStatement(quray);
		ps.setString(1, category.getId());
		ps.setString(2, category.getCategory());
		ps.setByte(3, category.getStatus());
		
		ps.executeUpdate();
		ps.close();
		connection.close();
		return category;
	}

	public boolean getdeletecat(String id) throws ClassNotFoundException, SQLException {
		Connection connection =connection();
		
		String quray ="UPDATE categorys SET status = 1 WHERE Id=? ";
		PreparedStatement ps=connection.prepareStatement(quray);
		ps.setString(1, id);
		
		boolean status=false;
		ps.executeUpdate(); 
		  

		return status=true;
	}

	public Category getEditCategoryDetails(String id) throws SQLException, ClassNotFoundException {
		Connection connection =connection();
		String quray ="SELECT * FROM categorys WHERE Id=?";
		
		PreparedStatement ps=connection.prepareStatement(quray);
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()){
			    rs.getString(1);
			}

		List<Category>categoryDeails=new ArrayList<Category>();
		
		Category category=new Category();
		category.setCategory(rs.getString("CATEGORYE"));
		category.setStatus(rs.getByte("status"));
		category.setId(rs.getString("id"));
		
			
		
		ps.close();
		connection.close();
		return category;
	}

	public List<Category> getCategorySearch(String categorySearch) throws ClassNotFoundException, SQLException {
		Connection connection =connection();
		String quray ="SELECT * FROM categorys WHERE categorye=?";
		
		PreparedStatement ps=connection.prepareStatement(quray);
		ps.setString(1, categorySearch);
		ResultSet rs=ps.executeQuery();
		
		List<Category>categoriesList=new ArrayList<Category>();
		
		while(rs.next()){
			Category category=new Category();
			category.setCategory(rs.getString("CATEGORYE"));
			category.setStatus(rs.getByte("status"));
			category.setId(rs.getString("id"));
			categoriesList.add(category);
		}
		ps.close();
		connection.close();
		return categoriesList;
	}
	

}
