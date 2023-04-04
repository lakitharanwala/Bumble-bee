package com.apassingment.bumblebee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.apassingment.bumblebee.model.Brand;
import com.apassingment.bumblebee.model.Category;
import com.apassingment.bumblebee.model.User;

public class BrandDAO {

	public DbConnector getConnector() {
		DbConnectorFcatory fac =new DbConnectorFactoryImpl();
			return fac.getdbconnection();
	}
	
	private Connection connection() throws ClassNotFoundException, SQLException {
		DbConnector dbconnector =getConnector();
		return dbconnector.getDbConnection();
	}
	
	public List<Brand> getAllbrands() throws ClassNotFoundException, SQLException {
		Connection connection =connection();
		String quray ="SELECT * FROM brand WHERE status = 0 ";
		
		Statement st= connection.createStatement();
		ResultSet rs=st.executeQuery(quray);
		
		List<Brand>brandList=new ArrayList<Brand>();
		
		while(rs.next()){
			Brand brand=new Brand();
			brand.setName(rs.getString("name"));
			brand.setStatus(rs.getByte("status"));
			brand.setId(rs.getString("id"));
			brandList.add(brand);
		}
			
		st.close();
		connection.close();
		return brandList;
	}

	public Brand saveBrand(Brand brand) throws ClassNotFoundException, SQLException {
		Connection connection =connection();
		String quray ="INSERT INTO brand(Id,name,status)"
				+ "VALUES (?,?,?)";
		
		PreparedStatement ps=connection.prepareStatement(quray);
		ps.setString(1, brand.getId());
		ps.setString(2, brand.getName());
		ps.setByte(3, brand.getStatus());
		
		ps.executeUpdate();
		ps.close();
		connection.close();
		return brand;
	}

	public boolean getDeleteBarnd(String id) throws ClassNotFoundException, SQLException {
		Connection connection =connection();
		
		String quray ="UPDATE brand SET status = 1 WHERE Id=? ";
		PreparedStatement ps=connection.prepareStatement(quray);
		ps.setString(1, id);
		
		boolean status=false;
		ps.executeUpdate(); 
		  

		return status=true;

	}

	public List<Brand> getBrandSearch(String barndSearch) throws ClassNotFoundException, SQLException {
		Connection connection =connection();
		String quray ="SELECT * FROM brand WHERE name=?";
		
		PreparedStatement ps=connection.prepareStatement(quray);
		ps.setString(1, barndSearch);
		ResultSet rs=ps.executeQuery();
		
		List<Brand>brandList=new ArrayList<Brand>();
		
		while(rs.next()){
			Brand brand=new Brand();
			brand.setName(rs.getString("name"));
			brand.setStatus(rs.getByte("status"));
			brand.setId(rs.getString("id"));
			brandList.add(brand);
		}
		ps.close();
		connection.close();
		return brandList;
	}

	public Brand getSaveEditor(Brand brand) throws ClassNotFoundException, SQLException {
		String id=brand.getId();
		Connection connection =connection();
		
		String quray="UPDATE brand SET name=? WHERE Id = ?";
		
		PreparedStatement ps=connection.prepareStatement(quray);
		ps.setString(1, brand.getName());
		ps.setString(2, id);
		ps.executeUpdate(); 
		
		
		return null;
	}
}

	
