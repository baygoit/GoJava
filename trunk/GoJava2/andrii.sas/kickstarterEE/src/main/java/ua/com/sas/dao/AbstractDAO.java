package ua.com.sas.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO {
	
	@Autowired
	DataSource dataSource;

	Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}