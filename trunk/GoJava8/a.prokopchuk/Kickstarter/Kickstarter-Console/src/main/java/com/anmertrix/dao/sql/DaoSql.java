package com.anmertrix.dao.sql;

import com.anmertrix.ConnectionManager;

public abstract class DaoSql {
	
	protected static ConnectionManager connectionManager;
	
	public static void initConnectionManager() {
		connectionManager = new ConnectionManager();
	}

}
