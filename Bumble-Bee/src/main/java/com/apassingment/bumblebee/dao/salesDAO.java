package com.apassingment.bumblebee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.apassingment.bumblebee.model.Products;
import com.apassingment.bumblebee.model.User;
import com.apassingment.bumblebee.model.UserHaveProducts;

public class salesDAO {

	
	public DbConnector getConnector() {
		DbConnectorFcatory fac =new DbConnectorFactoryImpl();
			return fac.getdbconnection();
	}
	
	private Connection connection() throws ClassNotFoundException, SQLException {
		DbConnector dbconnector =getConnector();
		return dbconnector.getDbConnection();
	}
	
	public List<UserHaveProducts> getAllsales() throws ClassNotFoundException, SQLException {
		Connection connection =connection();
		String quray ="SELECT * FROM user_has_products WHERE status = 0 ";
		String product ="SELECT * FROM products WHERE id =? ";
		String userName ="SELECT * FROM user WHERE user_id =? ";
		
		
		Statement st= connection.createStatement();
		ResultSet rs=st.executeQuery(quray);
		
		List<UserHaveProducts>salesList=new ArrayList<UserHaveProducts>();
		
		while(rs.next()){
			UserHaveProducts sales=new UserHaveProducts();
			sales.setLoanBalance(rs.getString("loan_balance"));
			sales.setId(rs.getString("Id"));
			sales.setProductId(rs.getString("product_Id"));;
			sales.setUserId(rs.getString("user_Id"));
			sales.setStatus(rs.getByte("status"));
			
			PreparedStatement prep=connection.prepareStatement(product);
			prep.setString(1, rs.getString("product_Id"));
			ResultSet rws=prep.executeQuery();
			
			while(rws.next()){
				sales.setProductName(rws.getString("name"));
			}
			
			PreparedStatement pre=connection.prepareStatement(userName);
			pre.setString(1, rs.getString("user_Id"));
			ResultSet res=pre.executeQuery();
			
			while(res.next()){
				sales.setUser(res.getString("FIRST_NAME"));
			}
			salesList.add(sales);
		}
		
		
		st.close();
		connection.close();
		return salesList;
	}

	public List<UserHaveProducts> getSearch(String search) throws SQLException, ClassNotFoundException {
		Connection connection =connection();
		String quray ="SELECT * FROM user_has_products WHERE user_id = ? ";
		String product ="SELECT * FROM products WHERE id =? ";
		String userName ="SELECT * FROM user WHERE user_id =? ";
		String user ="SELECT * FROM user WHERE first_name =? ";
		
		
		PreparedStatement pse=connection.prepareStatement(user);
		pse.setString(1, search);
		ResultSet rus=pse.executeQuery();
		
		User userdet=new User();
		while(rus.next()){
			userdet.setUserId(rus.getString("user_id"));
		}

		PreparedStatement ps=connection.prepareStatement(quray);
		ps.setString(1, userdet.getUserId());
		ResultSet rs=ps.executeQuery();
		
		List<UserHaveProducts>salesList=new ArrayList<UserHaveProducts>();
		
		while(rs.next()){
			UserHaveProducts sales=new UserHaveProducts();
			sales.setLoanBalance(rs.getString("loan_balance"));
			sales.setId(rs.getString("Id"));
			sales.setProductId(rs.getString("product_Id"));;
			sales.setUserId(rs.getString("user_Id"));
			sales.setStatus(rs.getByte("status"));
			
			PreparedStatement prep=connection.prepareStatement(product);
			prep.setString(1, rs.getString("product_Id"));
			ResultSet rws=prep.executeQuery();
			
			while(rws.next()){
				sales.setProductName(rws.getString("name"));
			}
			
			PreparedStatement pre=connection.prepareStatement(userName);
			pre.setString(1, rs.getString("user_Id"));
			ResultSet res=pre.executeQuery();
			
			while(res.next()){
				sales.setUser(res.getString("FIRST_NAME"));
			}
			salesList.add(sales);
		}
		
		
		ps.close();
		connection.close();
		return salesList;

	}

}
