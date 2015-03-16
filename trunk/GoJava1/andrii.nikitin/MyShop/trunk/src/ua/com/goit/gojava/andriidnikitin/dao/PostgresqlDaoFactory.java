package ua.com.goit.gojava.andriidnikitin.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.andriidnikitin.commons.ErrorLogger;
import ua.com.goit.gojava.andriidnikitin.dao.util.MyShopDaoException;
import ua.com.goit.gojava.andriidnikitin.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.domain.model.GoodIncoming;
import ua.com.goit.gojava.andriidnikitin.domain.model.GoodType;

public class PostgresqlDaoFactory  implements DaoFactory {

   private String driver = "org.postgresql.Driver";
      
   private static PostgresqlDaoFactory instance = null;
   
   private static final String CLASSNAME = PostgresqlDaoFactory.class.getCanonicalName();
   
   private static Logger log = Logger.getLogger("MyShop.DAO");
   
   public static PostgresqlDaoFactory getInstance(){
	   if (instance == null) {
		   instance = new PostgresqlDaoFactory();
	   }
	   return instance;
   }
    
    public Connection getConnection() throws MyShopDaoException {
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
			throw new MyShopDaoException(e);
		} catch (NamingException e) {
			String errorSpot = "establishing connect to " + lookup;		
			ErrorLogger.logNamingException(e, errorSpot, log);
			throw new MyShopDaoException(e);
		}
        return connection;
    }
    
    @Override
    public GenericDao<GoodType> getGoodTypeDao(Connection connection) {
        return new PostgresqlGoodTypeDao(connection);
    }
    
    private PostgresqlDaoFactory() {
        try {
            Class.forName(driver);
 		   log.info("Created new instance of " + CLASSNAME);
        } catch (ClassNotFoundException e) {
        	String errorSpot = " loading JDBC driver " + driver;        	
        	ErrorLogger.logClassNotFoundException(e, errorSpot, log);
            e.printStackTrace();
        }
    }

	@Override
	public GenericDao<Good> getGoodDao(Connection connection) {
		 return new PostgresqlGoodDao(connection);
	}

	@Override
	public GenericDao<GoodIncoming> getGoodIncomingDao(Connection connection) {
		 return new PostgresqlGoodIncomingDao(connection);
	}
	
}
