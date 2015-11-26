package ua.com.goit.gojava7.kickstarter.config;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.dao.file.FileCategoryReader;
import ua.com.goit.gojava7.kickstarter.dao.file.FilePaymentReader;
import ua.com.goit.gojava7.kickstarter.dao.file.FileProjectReader;
import ua.com.goit.gojava7.kickstarter.dao.file.FileQuestionReader;
import ua.com.goit.gojava7.kickstarter.dao.file.FileQuoteReader;
import ua.com.goit.gojava7.kickstarter.dao.file.FileRewardReader;
import ua.com.goit.gojava7.kickstarter.dao.memory.CategoryDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.PaymentDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.ProjectDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuestionDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuoteDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.RewardDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.mysql.QuoteDaoMySqlImpl;


public class DaoProvider {
	private static final File QUOTES_FILE = new File("./quotes.csv");
	private static final File CATEGORIES_FILE = new File("./categories.csv");
	private static final File PROJECTS_FILE = new File("./projects.csv");
	private static final File REWARDS_FILE = new File("./rewards.csv");
	private static final File QUESTIONS_FILE = new File("./questions.csv");
	private static final File PAYMENTS_FILE = new File("./payments.csv");
	
	private DataSource dataSource;
	
	private Connection connection = null;
	
	public DaoProvider(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void open() {
		if (dataSource == DataSource.MYSQL) {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kickstarter?user=user&password=Qwerty123");
			} catch (SQLException e) {
				throw new IllegalStateException("Cannot open connection. " + e.getMessage(), e);
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
	
	public QuoteDao getQuoteReader() {
		QuoteDao quoteDao;
		
		if (dataSource == DataSource.MYSQL) {
			quoteDao = new QuoteDaoMySqlImpl(connection); 
		} else if (dataSource == DataSource.MEMORY) {
			quoteDao = new QuoteDaoMemoryImpl(new Random()); 
		} else if (dataSource == DataSource.FILE) {
			quoteDao = new FileQuoteReader(QUOTES_FILE, new Random());
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSource);
		}
		return quoteDao;
	}

	public CategoryDao getCategoryReader() {
		if (dataSource != DataSource.FILE) {
			return new CategoryDaoMemoryImpl();
		} else {
			return new FileCategoryReader(CATEGORIES_FILE);
		}
	}

	public ProjectDao getProjectReader() {
		if (dataSource != DataSource.FILE) {
			return new ProjectDaoMemoryImpl();
		} else {
			return new FileProjectReader(PROJECTS_FILE);
		}
	}

	public RewardDao getRewardsReader() {
		if (dataSource != DataSource.FILE) {
			return new RewardDaoMemoryImpl();
		} else {
			return new FileRewardReader(REWARDS_FILE);
		}
	}

	public QuestionDao getQuestionReader() {
		if (dataSource != DataSource.FILE) {
			return new QuestionDaoMemoryImpl();
		} else {
			return new FileQuestionReader(QUESTIONS_FILE);
		}
	}

	public PaymentDao getPaymentReader() {
		if (dataSource != DataSource.FILE) {
			return new PaymentDaoMemoryImpl();
		} else {
			return new FilePaymentReader(PAYMENTS_FILE);
		}
	}

}
