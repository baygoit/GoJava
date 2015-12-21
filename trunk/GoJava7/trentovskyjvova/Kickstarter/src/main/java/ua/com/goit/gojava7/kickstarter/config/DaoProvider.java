package ua.com.goit.gojava7.kickstarter.config;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

import javax.sql.DataSource;

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

	private QuoteDao quoteDao;
	private CategoryDao categoryDao;
	private ProjectDao projectDao;
	private RewardDao rewardDao;
	private QuestionDao questionDao;
	private PaymentDao paymentDao;

	private DataSourceTypes dataSourceType;

	private DataSource dataSource;

	private Connection connection = null;

	public DaoProvider(DataSourceTypes dataSourceType) {
		this.dataSourceType = dataSourceType;
	}

	public DataSourceTypes getDataSourceType() {
		return dataSourceType;
	}

	public void setDataSourceType(DataSourceTypes dataSourceType) {
		this.dataSourceType = dataSourceType;
	}
	
	public DataSource getMyDataSource() {
		return dataSource;
	}

	public void setdataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void open() {

		if (dataSourceType == DataSourceTypes.POSTGRES || dataSourceType == DataSourceTypes.MYSQL) {
			try {
				connection = dataSource.getConnection();
			} catch (SQLException e) {
				throw new IllegalStateException("Cannot open connection. " + e.getMessage(), e);
			}
		}
		
	}

	public void close() {
		if ((dataSourceType.equals(DataSourceTypes.POSTGRES) || dataSourceType.equals(DataSourceTypes.MYSQL))
				&& connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new IllegalStateException("Cannot close connection " + connection + ". " + e.getMessage(), e);
			}
		}
	}

	public QuoteDao getQuoteReader() {
		if (quoteDao != null) {
			return quoteDao;
		}

		if (dataSourceType == DataSourceTypes.POSTGRES) {
			quoteDao = new QuoteDaoSqlImpl();
		} else if (dataSourceType == DataSourceTypes.MYSQL) {
			quoteDao = new QuoteDaoSqlImpl();
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
		if (categoryDao != null) {
			return categoryDao;
		}

		if (dataSourceType == DataSourceTypes.POSTGRES) {
			categoryDao = new CategoryDaoSqlImpl();
		} else if (dataSourceType == DataSourceTypes.MYSQL) {
			categoryDao = new CategoryDaoSqlImpl();
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
		if (projectDao != null) {
			return projectDao;
		}

		if (dataSourceType == DataSourceTypes.POSTGRES) {
			projectDao = new ProjectDaoSqlImpl();
		} else if (dataSourceType == DataSourceTypes.MYSQL) {
			projectDao = new ProjectDaoSqlImpl();
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
		if (rewardDao != null) {
			return rewardDao;
		}

		if (dataSourceType == DataSourceTypes.POSTGRES) {
			rewardDao = new RewardDaoSqlImpl();
		} else if (dataSourceType == DataSourceTypes.MYSQL) {
			rewardDao = new RewardDaoSqlImpl();
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
		if (questionDao != null) {
			return questionDao;
		}

		if (dataSourceType == DataSourceTypes.POSTGRES) {
			questionDao = new QuestionDaoSqlImpl();
		} else if (dataSourceType == DataSourceTypes.MYSQL) {
			questionDao = new QuestionDaoSqlImpl();
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
		if (paymentDao != null) {
			return paymentDao;
		}

		if (dataSourceType == DataSourceTypes.POSTGRES) {
			paymentDao = new PaymentDaoSqlImpl();
		} else if (dataSourceType == DataSourceTypes.MYSQL) {
			paymentDao = new PaymentDaoSqlImpl();
		} else if (dataSourceType == DataSourceTypes.MEMORY) {
			paymentDao = new PaymentDaoMemoryImpl();
		} else if (dataSourceType == DataSourceTypes.FILE) {
			paymentDao = new PaymentDaoFileImpl(PAYMENTS_FILE);
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSourceType);
		}
		return paymentDao;
	}

}
