package ua.com.goit.gojava7.kickstarter.config;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.FaqDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.dao.mysql.CategoryDaoMysqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.mysql.FaqDaoMysqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.mysql.PaymentDaoMysqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.mysql.ProjectDaoMysqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.mysql.QuoteDaoMysqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.mysql.RewardDaoMysqlImpl;

public class DaoProvider {
	
	private DataSource dataSource;
	private Connection connection = null;

	public DaoProvider(DataSource dataSource) {
		
		this.dataSource = dataSource;
		
	}

	public void open() {
		
		if (dataSource == DataSource.MYSQL) {
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				connection = MysqlProvider.getInstance().getConnection();
				
			} catch (SQLException e) {
				
				throw new IllegalStateException("Cannot open connection. " + e.getMessage(), e);
				
			} catch (ClassNotFoundException e) {
				
				throw new IllegalStateException("Cannot open load mysql driver. " + e.getMessage(), e);
				
			} catch (IOException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (PropertyVetoException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void close() {
		
		if (dataSource == DataSource.MYSQL) {
			
			try {
				
				if (connection != null) {
					
					connection.close();
					
				}
				
			} catch (SQLException e) {
				
				throw new IllegalStateException("Cannot close connection " + connection + ". " + e.getMessage(), e);
				
			}
		}
	}

	public QuoteDao getQuoteDao() {
		
		QuoteDao quoteDao;
		
		if (dataSource == DataSource.MYSQL) {
			
			QuoteDaoMysqlImpl quoteDaoMySqlImpl = new QuoteDaoMysqlImpl(connection);
			
			quoteDao = quoteDaoMySqlImpl;
			
		} else {
			
			throw new IllegalArgumentException("Unknown data source " + dataSource);
			
		}
		
		return quoteDao;
	}

	public CategoryDao getCategoryDao() {
		
		CategoryDao categoryDao;

		if (dataSource == DataSource.MYSQL) {
			
			CategoryDaoMysqlImpl categoryDaoMysqlImpl = new CategoryDaoMysqlImpl(connection);
			
			categoryDao = categoryDaoMysqlImpl;
			
		} else {
			
			throw new IllegalArgumentException("Unknown data source " + dataSource);
			
		}
		
		return categoryDao;
	}
	
	public FaqDao getFaqDao() {
		
		FaqDao faqDao;

		if (dataSource == DataSource.MYSQL) {
			
			FaqDaoMysqlImpl faqDaoMysqlImpl = new FaqDaoMysqlImpl(connection);
			
			faqDao = faqDaoMysqlImpl;
			
		} else {
			
			throw new IllegalArgumentException("Unknown data source " + dataSource);
			
		}
		
		return faqDao;
	}
	
	public PaymentDao getPaymentDao() {
		
		PaymentDao paymentDao;

		if (dataSource == DataSource.MYSQL) {
			
			PaymentDaoMysqlImpl paymentDaoMysqlImpl = new PaymentDaoMysqlImpl(connection);
			
			paymentDao = paymentDaoMysqlImpl;
			
		} else {
			
			throw new IllegalArgumentException("Unknown data source " + dataSource);
			
		}
		
		return paymentDao;
	}
	
	public ProjectDao getProjectDao() {
		
		ProjectDao projectDao;

		if (dataSource == DataSource.MYSQL) {
			
			ProjectDaoMysqlImpl projectDaoMysqlImpl = new ProjectDaoMysqlImpl(connection);
			
			projectDao = projectDaoMysqlImpl;
			
		} else {
			
			throw new IllegalArgumentException("Unknown data source " + dataSource);
			
		}
		
		return projectDao;
	}
	
	public RewardDao RewardDao() {
		
		RewardDao rewardDao;

		if (dataSource == DataSource.MYSQL) {
			
			RewardDaoMysqlImpl rewardDaoMysqlImpl = new RewardDaoMysqlImpl(connection);
			
			rewardDao = rewardDaoMysqlImpl;
			
		} else {
			
			throw new IllegalArgumentException("Unknown data source " + dataSource);
			
		}
		
		return rewardDao;
	}
	
}
