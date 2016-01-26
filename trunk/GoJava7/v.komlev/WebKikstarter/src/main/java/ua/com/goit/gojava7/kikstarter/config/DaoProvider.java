package ua.com.goit.gojava7.kikstarter.config;

//import java.beans.PropertyVetoException;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import ua.com.goit.gojava7.kikstarter.dao.CategoryDao;
//import ua.com.goit.gojava7.kikstarter.dao.PaymentDao;
//import ua.com.goit.gojava7.kikstarter.dao.ProjectDao;
//import ua.com.goit.gojava7.kikstarter.dao.QuoteDao;
//import ua.com.goit.gojava7.kikstarter.dao.RewardDao;
//import ua.com.goit.gojava7.kikstarter.dao.database.CategoryDaoDbImpl;
//import ua.com.goit.gojava7.kikstarter.dao.database.PaymentDaoDbImpl;
//import ua.com.goit.gojava7.kikstarter.dao.database.ProjectDaoDbImpl;
//import ua.com.goit.gojava7.kikstarter.dao.database.QuoteDaoDbImpl;
//import ua.com.goit.gojava7.kikstarter.dao.database.RewardDaoDbImpl;

public class DaoProvider {

//	private MyDataSource myDataSource;
//	private ConnectionPoolSource connectionPoolSource;
//	private Connection connection;
//
//	public DaoProvider(MyDataSource myDataSource) {
//		this.myDataSource = myDataSource;
//	}
//
//	public void open() {
//		if (myDataSource == MyDataSource.ORACLE) {
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//
//				connectionPoolSource = ConnectionPoolSource.getInstance();
//			} catch (SQLException e) {
//				throw new IllegalStateException("Cannot open connection. " + e.getMessage(), e);
//			} catch (ClassNotFoundException e) {
//				throw new IllegalStateException("Cannot open load mysql driver. " + e.getMessage(), e);
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (PropertyVetoException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public void close() throws IOException, PropertyVetoException {
//		if (myDataSource == MyDataSource.ORACLE) {
//			try {
//				if (connection != null) {
//					connection.close();
//				}
//			} catch (SQLException e) {
//				throw new IllegalStateException(
//						"Cannot close connection " + connectionPoolSource + ". " + e.getMessage(), e);
//			}
//		}
//	}
//
//	public QuoteDao getQuoteDao() {
//		QuoteDao quoteDao;
//		if (myDataSource == MyDataSource.ORACLE) {
//			QuoteDaoDbImpl quoteDaoDbImpl = new QuoteDaoDbImpl(connectionPoolSource);
//			quoteDao = quoteDaoDbImpl;
//		} else {
//			throw new IllegalArgumentException("Unknown data source " + myDataSource);
//		}
//
//		return quoteDao;
//	}
//
//	public CategoryDao getCategoryDao() {
//		CategoryDao categoryDao;
//		if (myDataSource == MyDataSource.ORACLE) {
//			CategoryDaoDbImpl categoryDaoDbImpl = new CategoryDaoDbImpl(connectionPoolSource);
//			categoryDao = categoryDaoDbImpl;
//		} else {
//			throw new IllegalArgumentException("Unknown data source " + myDataSource);
//		}
//
//		return categoryDao;
//	}
//
//	public ProjectDao getProjectDao() {
//		ProjectDao projectDao;
//		if (myDataSource == MyDataSource.ORACLE) {
//			ProjectDaoDbImpl projectDaoDbImpl = new ProjectDaoDbImpl(connectionPoolSource);
//			projectDao = projectDaoDbImpl;
//		} else {
//			throw new IllegalArgumentException("Unknown data source " + myDataSource);
//		}
//
//		return projectDao;
//	}
//
//	public RewardDao getRewardDao() {
//		RewardDao rewardDao;
//		if (myDataSource == MyDataSource.ORACLE) {
//			RewardDaoDbImpl rewardDaoDbImpl = new RewardDaoDbImpl(connectionPoolSource);
//			rewardDao = rewardDaoDbImpl;
//		} else {
//			throw new IllegalArgumentException("Unknown data source " + myDataSource);
//		}
//
//		return rewardDao;
//	}
//	
//	public PaymentDao getPaymentDao(){
//		PaymentDao paymentDao;
//		if(myDataSource == MyDataSource.ORACLE){
//			PaymentDaoDbImpl paymentDaoDbImpl = new PaymentDaoDbImpl(connectionPoolSource);
//			paymentDao = paymentDaoDbImpl;
//		} else {
//			throw new IllegalArgumentException("Unknown data source " + myDataSource);
//		}
//		
//		return paymentDao;
//	}
}
