package com.apassingment.bumblebee.dao;

public class DbConnectorFactoryImpl implements DbConnectorFcatory{

	@Override
	public DbConnector getdbconnection() {
		return new  DbConnectionImpl();
	}

}
