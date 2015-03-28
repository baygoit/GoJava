package ua.com.goit.gojava.andriidnikitin.MyShop.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.andriidnikitin.MyShop.commons.ErrorLogger;
import ua.com.goit.gojava.andriidnikitin.MyShop.commons.MyContextLoader;
import ua.com.goit.gojava.andriidnikitin.MyShop.db.util.MyShopDaoException;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodIncoming;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodType;

public class PostgresqlDaoFactory  implements DaoFactory {

   private DataSource dataSource;
   
   public PostgresqlDaoFactory() {   
	   
   }
      
   public DataSource getDataSource() {
	   return dataSource;
   }

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	      
   private static Logger log = Logger.getLogger("MyShop.DAO");
        
    public Connection getConnection() throws MyShopDaoException {   
    	if (dataSource == null){
    		log.warn("DataSource is null");
    	}    	
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
    	PostgresqlGoodTypeDao dao = getGoodTypeDaoInstance();
		dao.setConnection(connection);
		return dao;
    }

	@Override
	public GenericDao<Good> getGoodDao(Connection connection) {
		PostgresqlGoodDao dao = getGoodDaoInstance();
		dao.setConnection(connection);
		return dao;
	}

	@Override
	public GenericDao<GoodIncoming> getGoodIncomingDao(Connection connection) {
		PostgresqlGoodIncomingDao dao = getGoodIncomingDaoInstance();
		dao.setConnection(connection);
		return dao;
	}
	
	public PostgresqlGoodIncomingDao getGoodIncomingDaoInstance(){
		return MyContextLoader.getBean(PostgresqlGoodIncomingDao.class);
	}
	public PostgresqlGoodTypeDao getGoodTypeDaoInstance(){
		return MyContextLoader.getBean(PostgresqlGoodTypeDao.class);
	}
	public PostgresqlGoodDao getGoodDaoInstance(){
		return MyContextLoader.getBean(PostgresqlGoodDao.class);
		
	}
	
}
