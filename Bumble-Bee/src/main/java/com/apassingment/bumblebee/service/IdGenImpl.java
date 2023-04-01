package com.apassingment.bumblebee.service;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.SQLException;

import com.apassingment.bumblebee.dao.DbConnector;

public class IdGenImpl implements IdGen{

	public String getId() throws ClassNotFoundException {
		String idGen = null;
		 SecureRandom rand = new SecureRandom();
	        int upperbound = 100000000;
	        int id = rand.nextInt(upperbound);
	        idGen=String.valueOf(id);
	         
		 
		 return idGen;
	}

	
	
}

