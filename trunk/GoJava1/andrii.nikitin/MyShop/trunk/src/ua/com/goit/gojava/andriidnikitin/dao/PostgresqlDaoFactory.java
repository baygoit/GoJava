package ua.com.goit.gojava.andriidnikitin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;

public class PostgresqlDaoFactory implements CatalogDaoFactory{

	    private String user = "postgres";
	    private String password = "mypass";
	    private String url = "jdbc:postgresql://localhost:5432/shop";
	    private String driver = "org.postgresql.Driver";

	    public Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url, user, password);
	    }

	    @Override
	    public GenericDao getGoodDao(Connection connection) {
	        return new PostgresqlGoodDao(connection);
	    }

	    @Override
	    public GenericDao getGoodTypeDao(Connection connection) {
	    	return new PostgresqlGoodTypeDao(connection);
	    }

	    public PostgresqlDaoFactory() {
	        try {
	            Class.forName(driver);//Регистрируем драйвер
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	}
