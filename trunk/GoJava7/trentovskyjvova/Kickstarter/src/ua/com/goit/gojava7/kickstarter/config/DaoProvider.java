package ua.com.goit.gojava7.kickstarter.config;

import javax.sql.DataSource;

import java.io.File;
import java.sql.Connection;
import java.util.Properties;
import java.util.Random;
import java.sql.SQLException;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.dao.file.CategoryDaoFileImpl;
import ua.com.goit.gojava7.kickstarter.dao.file.PaymentDaoFileImpl;
import ua.com.goit.gojava7.kickstarter.dao.file.ProjectDaoFileImpl;
import ua.com.goit.gojava7.kickstarter.dao.file.QuestionDaoFileImpl;
import ua.com.goit.gojava7.kickstarter.dao.file.QuoteDaoFileImpl;
import ua.com.goit.gojava7.kickstarter.dao.file.RewardDaoFileImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.CategoryDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.PaymentDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.ProjectDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuestionDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuoteDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.RewardDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.sql.CategoryDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.sql.PaymentDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.sql.ProjectDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.sql.QuestionDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.sql.QuoteDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.sql.RewardDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.exception.IODatabaseException;

public class DaoProvider {
	private static final File QUOTES_FILE = new File("./quotes.csv");
	private static final File CATEGORIES_FILE = new File("./categories.csv");
	private static final File PROJECTS_FILE = new File("./projects.csv");
	private static final File REWARDS_FILE = new File("./rewards.csv");
	private static final File QUESTIONS_FILE = new File("./questions.csv");
	private static final File PAYMENTS_FILE = new File("./payments.csv");

	private DataSourceTypes dataSourceType;

	private DataSource dataSource;
	
	public DaoProvider(DataSourceTypes dataSourceType) {
		this.dataSourceType = dataSourceType;
	}
	
	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot open connection. " + e.getMessage(), e);
		} 
	}
	
	public DataSourceTypes getDataSourceType() {
		return dataSourceType;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setDataSourceType(DataSourceTypes dataSourceType) {
		this.dataSourceType = dataSourceType;
	}

	public void init() {

		if (dataSourceType == DataSourceTypes.MYSQL) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				throw new IODatabaseException("Error loading mysql driver: ", ex);

			}
			setDataSource(setupDataSource("jdbc:mysql://localhost:3306/kickstarter"));
		} else if (dataSourceType == DataSourceTypes.POSTGRES) {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException ex) {
				throw new IODatabaseException("Error loading Postgres driver: ", ex);

			}
			setDataSource(setupDataSource("jdbc:postgresql://localhost:5432/kickstarter"));
		}

	}

	public void close() {
		/*
		 * if (dataSourceType == DataSourceTypes.MYSQL || dataSourceType ==
		 * DataSourceTypes.POSTGRES) { try { if (connection != null) {
		 * connection.close(); } } catch (SQLException e) { throw new
		 * IllegalStateException("Cannot close connection " + connection + ". "
		 * + e.getMessage(), e); } }
		 */
	}

	public QuoteDao getQuoteReader() {
		QuoteDao quoteDao;

		if (dataSourceType == DataSourceTypes.MYSQL) {
			quoteDao = new QuoteDaoSqlImpl(this);
		} else if (dataSourceType == DataSourceTypes.POSTGRES) {
			quoteDao = new QuoteDaoSqlImpl(this);
		} else if (dataSourceType == DataSourceTypes.MEMORY) {
			quoteDao = new QuoteDaoMemoryImpl(new Random());
		} else if (dataSourceType == DataSourceTypes.FILE) {
			quoteDao = new QuoteDaoFileImpl(QUOTES_FILE, new Random());
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSourceType);
		}
		return quoteDao;
	}

	public CategoryDao getCategoryReader() {
		CategoryDao categoryDao;

		if (dataSourceType == DataSourceTypes.MYSQL) {
			categoryDao = new CategoryDaoSqlImpl(this);
		} else if (dataSourceType == DataSourceTypes.POSTGRES) {
			categoryDao = new CategoryDaoSqlImpl(this);
		} else if (dataSourceType == DataSourceTypes.MEMORY) {
			categoryDao = new CategoryDaoMemoryImpl();
		} else if (dataSourceType == DataSourceTypes.FILE) {
			categoryDao = new CategoryDaoFileImpl(CATEGORIES_FILE);
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSourceType);
		}
		return categoryDao;
	}

	public ProjectDao getProjectReader() {
		ProjectDao projectDao;

		if (dataSourceType == DataSourceTypes.MYSQL) {
			projectDao = new ProjectDaoSqlImpl(this);
		} else if (dataSourceType == DataSourceTypes.POSTGRES) {
			projectDao = new ProjectDaoSqlImpl(this);
		} else if (dataSourceType == DataSourceTypes.MEMORY) {
			projectDao = new ProjectDaoMemoryImpl();
		} else if (dataSourceType == DataSourceTypes.FILE) {
			projectDao = new ProjectDaoFileImpl(PROJECTS_FILE);
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSourceType);
		}
		return projectDao;
	}

	public RewardDao getRewardsReader() {
		RewardDao rewardDao;

		if (dataSourceType == DataSourceTypes.MYSQL) {
			rewardDao = new RewardDaoSqlImpl(this);
		} else if (dataSourceType == DataSourceTypes.POSTGRES) {
			rewardDao = new RewardDaoSqlImpl(this);
		} else if (dataSourceType == DataSourceTypes.MEMORY) {
			rewardDao = new RewardDaoMemoryImpl();
		} else if (dataSourceType == DataSourceTypes.FILE) {
			rewardDao = new RewardDaoFileImpl(REWARDS_FILE);
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSourceType);
		}
		return rewardDao;
	}

	public QuestionDao getQuestionReader() {
		QuestionDao questionDao;

		if (dataSourceType == DataSourceTypes.MYSQL) {
			questionDao = new QuestionDaoSqlImpl(this);
		} else if (dataSourceType == DataSourceTypes.POSTGRES) {
			questionDao = new QuestionDaoSqlImpl(this);
		} else if (dataSourceType == DataSourceTypes.MEMORY) {
			questionDao = new QuestionDaoMemoryImpl();
		} else if (dataSourceType == DataSourceTypes.FILE) {
			questionDao = new QuestionDaoFileImpl(QUESTIONS_FILE);
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSourceType);
		}
		return questionDao;
	}

	public PaymentDao getPaymentReader() {
		PaymentDao paymentDao;

		if (dataSourceType == DataSourceTypes.MYSQL) {
			paymentDao = new PaymentDaoSqlImpl(this);
		} else if (dataSourceType == DataSourceTypes.POSTGRES) {
			paymentDao = new PaymentDaoSqlImpl(this);
		} else if (dataSourceType == DataSourceTypes.MEMORY) {
			paymentDao = new PaymentDaoMemoryImpl();
		} else if (dataSourceType == DataSourceTypes.FILE) {
			paymentDao = new PaymentDaoFileImpl(PAYMENTS_FILE);
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSourceType);
		}
		return paymentDao;
	}

	public DataSource setupDataSource(String connectURI) {

		Properties props = new Properties();
		props.setProperty("user", "user");
		props.setProperty("password", "Qwerty123");
		props.setProperty("initialSize", "10");
		
		ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(connectURI, props);

		PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);

		ObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnectionFactory);

		poolableConnectionFactory.setPool(connectionPool);

		PoolingDataSource<PoolableConnection> dataSource = new PoolingDataSource<>(connectionPool);

		return dataSource;
	}

}
