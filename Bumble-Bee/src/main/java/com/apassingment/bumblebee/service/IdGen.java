package com.apassingment.bumblebee.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface IdGen {

	String getId() throws ClassNotFoundException;
	
}
