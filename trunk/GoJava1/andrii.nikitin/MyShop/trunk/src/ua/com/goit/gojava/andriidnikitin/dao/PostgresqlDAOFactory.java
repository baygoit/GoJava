package ua.com.goit.gojava.andriidnikitin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ua.com.goit.gojava.andriidnikitin.dao.util.MyShopDAOException;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;

public class PostgresqlDAOFactory  implements DAOFactory {

    private String user = "postgres";
    private String password = "mypass";
    private String url = "jdbc:postgresql://localhost:5432/shop";
    private String driver = "org.postgresql.Driver";
    
    public Connection getConnectionInNewWay() throws MyShopDAOException {
    	Connection connection = null;
        try {
        	Context ctx = new InitialContext();
    		DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/StudentsDS");
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new MyShopDAOException(e);
		} catch (NamingException e) {
			throw new MyShopDAOException(e);
		}
        return connection;
    }
    
    public Connection getConnection() throws MyShopDAOException {
        try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			 throw new MyShopDAOException(e);
		}
    }

    
    @Override
    public GenericDAO<GoodType> getGoodTypeDAO(Connection connection) {
        return new PostgresqlGoodTypeDAO(connection);
    }
    
    public PostgresqlDAOFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
