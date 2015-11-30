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
import ua.com.goit.gojava7.kickstarter.dao.mysql.CategoryDaoMySqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.mysql.PaymentDaoMySqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.mysql.ProjectDaoMySqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.mysql.QuestionDaoMySqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.mysql.QuoteDaoMySqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.mysql.RewardDaoMySqlImpl;

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
				connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/kickstarter?user=user&password=Qwerty123");
			} catch (SQLException e) {
				throw new IllegalStateException("Cannot open connection. "
						+ e.getMessage(), e);
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
				throw new IllegalStateException("Cannot close connection "
						+ connection + ". " + e.getMessage(), e);
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
			quoteDao = new QuoteDaoFileImpl(QUOTES_FILE, new Random());
		} else {
			throw new IllegalArgumentException("Unknown data source "
					+ dataSource);
		}
		return quoteDao;
	}

	public CategoryDao getCategoryReader() {
		CategoryDao categoryDao;

		if (dataSource == DataSource.MYSQL) {
			categoryDao = new CategoryDaoMySqlImpl(connection);
		} else if (dataSource == DataSource.MEMORY) {
			categoryDao = new CategoryDaoMemoryImpl();
		} else if (dataSource == DataSource.FILE) {
			categoryDao = new CategoryDaoFileImpl(CATEGORIES_FILE);
		} else {
			throw new IllegalArgumentException("Unknown data source "
					+ dataSource);
		}
		return categoryDao;
	}

	public ProjectDao getProjectReader() {
		ProjectDao projectDao;

		if (dataSource == DataSource.MYSQL) {
			projectDao = new ProjectDaoMySqlImpl(connection);
		} else if (dataSource == DataSource.MEMORY) {
			projectDao = new ProjectDaoMemoryImpl();
		} else if (dataSource == DataSource.FILE) {
			projectDao = new ProjectDaoFileImpl(PROJECTS_FILE);
		} else {
			throw new IllegalArgumentException("Unknown data source "
					+ dataSource);
		}
		return projectDao;
	}

	public RewardDao getRewardsReader() {
		RewardDao rewardDao;

		if (dataSource == DataSource.MYSQL) {
			rewardDao = new RewardDaoMySqlImpl(connection);
		} else if (dataSource == DataSource.MEMORY) {
			rewardDao = new RewardDaoMemoryImpl();
		} else if (dataSource == DataSource.FILE) {
			rewardDao = new RewardDaoFileImpl(REWARDS_FILE);
		} else {
			throw new IllegalArgumentException("Unknown data source "
					+ dataSource);
		}
		return rewardDao;
	}

	public QuestionDao getQuestionReader() {
		QuestionDao questionDao;

		if (dataSource == DataSource.MYSQL) {
			questionDao = new QuestionDaoMySqlImpl(connection);
		} else if (dataSource == DataSource.MEMORY) {
			questionDao = new QuestionDaoMemoryImpl();
		} else if (dataSource == DataSource.FILE) {
			questionDao = new QuestionDaoFileImpl(QUESTIONS_FILE);
		} else {
			throw new IllegalArgumentException("Unknown data source "
					+ dataSource);
		}
		return questionDao;
	}

	public PaymentDao getPaymentReader() {
		PaymentDao paymentDao;

		if (dataSource == DataSource.MYSQL) {
			paymentDao = new PaymentDaoMySqlImpl(connection);
		} else if (dataSource == DataSource.MEMORY) {
			paymentDao = new PaymentDaoMemoryImpl();
		} else if (dataSource == DataSource.FILE) {
			paymentDao = new PaymentDaoFileImpl(PAYMENTS_FILE);
		} else {
			throw new IllegalArgumentException("Unknown data source "
					+ dataSource);
		}
		return paymentDao;
	}

}
