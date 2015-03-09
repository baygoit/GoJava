package ua.com.sas.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class AbstractDAO {

	DataSource dataSource;

	Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}