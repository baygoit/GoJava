package com.go_java4.alex_mirn.dao;

import java.sql.Connection;

public interface ConnectionPool extends AutoCloseable{
	public Connection getConnection();
}
