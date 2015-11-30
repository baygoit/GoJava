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
import ua.com.goit.gojava7.kickstarter.dao.sql.CategoryDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.sql.PaymentDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.sql.ProjectDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.sql.QuestionDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.sql.QuoteDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.sql.RewardDaoSqlImpl;

public class DaoProvider {
	private static final File QUOTES_FILE = new File("./quotes.csv");
	private static final File CATEGORIES_FILE = new File("./categories.csv");
	private static final File PROJECTS_FILE = new File("./projects.csv");
	private static final File REWARDS_FILE = new File("./rewards.csv");
	private static final File QUESTIONS_FILE = new File("./questions.csv");
	private static final File PAYMENTS_FILE = new File("./payments.csv");

	private DataSourceTypes dataSource;

	private Connection connection = null;

	public DaoProvider(DataSourceTypes dataSource) {
		this.dataSource = dataSource;
	}

	public DataSourceTypes getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSourceTypes dataSource) {
		this.dataSource = dataSource;
	}

	public Connection open() {
		if (dataSource == DataSourceTypes.MYSQL) {
			try {
				if (connection == null || connection.isClosed()) {
					connection = DriverManager
							.getConnection("jdbc:mysql://localhost:3306/kickstarter?user=user&password=Qwerty123");
				}
			} catch (SQLException e) {
				throw new IllegalStateException("Cannot open connection. " + e.getMessage(), e);
			}
		} else if (dataSource == DataSourceTypes.POSTGRES) {
			try {
				if (connection == null || connection.isClosed()) {
					connection = DriverManager
							.getConnection("jdbc:postgresql://localhost/kickstarter?user=user&password=Qwerty123&tcpKeepAlive=true");
				}
			} catch (SQLException e) {
				throw new IllegalStateException("Cannot open connection. " + e.getMessage(), e);
			}
		}
		return connection;
	}

	public void close() {
		if (dataSource == DataSourceTypes.MYSQL || dataSource == DataSourceTypes.POSTGRES) {
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

		if (dataSource == DataSourceTypes.MYSQL) {
			quoteDao = new QuoteDaoSqlImpl(this);
		} else if (dataSource == DataSourceTypes.POSTGRES) {
			quoteDao = new QuoteDaoSqlImpl(this);
		} else if (dataSource == DataSourceTypes.MEMORY) {
			quoteDao = new QuoteDaoMemoryImpl(new Random());
		} else if (dataSource == DataSourceTypes.FILE) {
			quoteDao = new QuoteDaoFileImpl(QUOTES_FILE, new Random());
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSource);
		}
		return quoteDao;
	}

	public CategoryDao getCategoryReader() {
		CategoryDao categoryDao;

		if (dataSource == DataSourceTypes.MYSQL) {
			categoryDao = new CategoryDaoSqlImpl(this);
		} else if (dataSource == DataSourceTypes.POSTGRES) {
			categoryDao = new CategoryDaoSqlImpl(this);
		} else if (dataSource == DataSourceTypes.MEMORY) {
			categoryDao = new CategoryDaoMemoryImpl();
		} else if (dataSource == DataSourceTypes.FILE) {
			categoryDao = new CategoryDaoFileImpl(CATEGORIES_FILE);
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSource);
		}
		return categoryDao;
	}

	public ProjectDao getProjectReader() {
		ProjectDao projectDao;

		if (dataSource == DataSourceTypes.MYSQL) {
			projectDao = new ProjectDaoSqlImpl(this);
		} else if (dataSource == DataSourceTypes.POSTGRES) {
			projectDao = new ProjectDaoSqlImpl(this);
		} else if (dataSource == DataSourceTypes.MEMORY) {
			projectDao = new ProjectDaoMemoryImpl();
		} else if (dataSource == DataSourceTypes.FILE) {
			projectDao = new ProjectDaoFileImpl(PROJECTS_FILE);
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSource);
		}
		return projectDao;
	}

	public RewardDao getRewardsReader() {
		RewardDao rewardDao;

		if (dataSource == DataSourceTypes.MYSQL) {
			rewardDao = new RewardDaoSqlImpl(this);
		} else if (dataSource == DataSourceTypes.POSTGRES) {
			rewardDao = new RewardDaoSqlImpl(this);
		} else if (dataSource == DataSourceTypes.MEMORY) {
			rewardDao = new RewardDaoMemoryImpl();
		} else if (dataSource == DataSourceTypes.FILE) {
			rewardDao = new RewardDaoFileImpl(REWARDS_FILE);
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSource);
		}
		return rewardDao;
	}

	public QuestionDao getQuestionReader() {
		QuestionDao questionDao;

		if (dataSource == DataSourceTypes.MYSQL) {
			questionDao = new QuestionDaoSqlImpl(this);
		} else if (dataSource == DataSourceTypes.POSTGRES) {
			questionDao = new QuestionDaoSqlImpl(this);
		} else if (dataSource == DataSourceTypes.MEMORY) {
			questionDao = new QuestionDaoMemoryImpl();
		} else if (dataSource == DataSourceTypes.FILE) {
			questionDao = new QuestionDaoFileImpl(QUESTIONS_FILE);
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSource);
		}
		return questionDao;
	}

	public PaymentDao getPaymentReader() {
		PaymentDao paymentDao;

		if (dataSource == DataSourceTypes.MYSQL) {
			paymentDao = new PaymentDaoSqlImpl(this);
		} else if (dataSource == DataSourceTypes.POSTGRES) {
			paymentDao = new PaymentDaoSqlImpl(this);
		} else if (dataSource == DataSourceTypes.MEMORY) {
			paymentDao = new PaymentDaoMemoryImpl();
		} else if (dataSource == DataSourceTypes.FILE) {
			paymentDao = new PaymentDaoFileImpl(PAYMENTS_FILE);
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSource);
		}
		return paymentDao;
	}

}
