package ua.com.goit.gojava.andriidnikitin.MyShop.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import ua.com.goit.gojava.andriidnikitin.MyShop.commons.ErrorLogger;
import ua.com.goit.gojava.andriidnikitin.MyShop.db.util.DataSourceProvider;
import ua.com.goit.gojava.andriidnikitin.MyShop.db.util.MyShopDaoException;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodIncoming;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodType;
public class PostgresqlDaoFactory  implements DaoFactory {

   private String driver = "org.postgresql.Driver";
   
   /*
    * @Autowired
   private DataSource dataSource;  
   */ 
   //TODO - delete
   private DataSource dataSource = DataSourceProvider.getDataSource();  
      
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
    	log.info("datasource is null?" + dataSource==null);
        try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			ErrorLogger.logSQLException(e, "getting connection ", log);
		}
        return null;
    }
    
    @SuppressWarnings("unused")
	private Connection getConnectionInOldWay() throws MyShopDaoException {
    	Connection connection = null;
    	String lookup = "java:comp/env/jdbc/ShopDS";
        try {
        	Context ctx = new InitialContext();    		
        	javax.sql.DataSource dataSource = (javax.sql.DataSource) ctx.lookup(lookup);
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
