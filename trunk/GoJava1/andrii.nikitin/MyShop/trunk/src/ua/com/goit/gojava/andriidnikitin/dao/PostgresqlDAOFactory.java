package ua.com.goit.gojava.andriidnikitin.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.andriidnikitin.dao.util.MyShopDAOException;
import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.util.ErrorLogger;

public class PostgresqlDAOFactory  implements DAOFactory {

   private String driver = "org.postgresql.Driver";
      
   private static PostgresqlDAOFactory instance = null;
   
   private static String className = PostgresqlDAOFactory.class.getCanonicalName();
   
   private static Logger log = Logger.getLogger("MyShop.DAO");
   
   public static PostgresqlDAOFactory getInstance(){
	   if (instance == null) {
		   instance = new PostgresqlDAOFactory();
		   log.info("Created new instance of " + className);
	   }
	   return instance;
   }
    
    public Connection getConnection() throws MyShopDAOException {
    	Connection connection = null;
    	String lookup = "java:comp/env/jdbc/ShopDS";
        try {
        	Context ctx = new InitialContext();    		
        	DataSource dataSource = (DataSource) ctx.lookup(lookup);
			connection = dataSource.getConnection();
			log.info("New connection to " + lookup + " was established");
		} catch (SQLException e) {			
			String errorSpot = "establishing connect to " + lookup;
			ErrorLogger.logSQLException(e, errorSpot, log);
			throw new MyShopDAOException(e);
		} catch (NamingException e) {
			String errorSpot = "establishing connect to " + lookup;		
			ErrorLogger.logNamingException(e, errorSpot, log);
			throw new MyShopDAOException(e);
		}
        return connection;
    }
    
    @Override
    public GenericDAO<GoodType> getGoodTypeDAO(Connection connection) {
        return new PostgresqlGoodTypeDAO(connection);
    }
    
    private PostgresqlDAOFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
        	String errorSpot = " loading JDBC driver " + driver;        	
        	ErrorLogger.logClassNotFoundException(e, errorSpot, log);
            e.printStackTrace();
        }
    }

	@Override
	public GenericDAO<Good> getGoodDAO(Connection connection) {
		 return new PostgresqlGoodDAO(connection);
	}
	
}
