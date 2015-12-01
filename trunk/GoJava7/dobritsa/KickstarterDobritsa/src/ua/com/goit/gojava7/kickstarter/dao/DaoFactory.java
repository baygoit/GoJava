package ua.com.goit.gojava7.kickstarter.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import ua.com.goit.gojava7.kickstarter.dao.db.CategoryDbDao;
import ua.com.goit.gojava7.kickstarter.dao.db.ProjectDbDao;
import ua.com.goit.gojava7.kickstarter.dao.db.QuestionDbDao;
import ua.com.goit.gojava7.kickstarter.dao.db.QuoteDbDao;
import ua.com.goit.gojava7.kickstarter.dao.db.RewardDbDao;
import ua.com.goit.gojava7.kickstarter.dao.file.CategoryFileDao;
import ua.com.goit.gojava7.kickstarter.dao.file.ProjectFileDao;
import ua.com.goit.gojava7.kickstarter.dao.file.QuestionsFileDao;
import ua.com.goit.gojava7.kickstarter.dao.file.QuoteFileDao;
import ua.com.goit.gojava7.kickstarter.dao.file.RewardFileDao;
import ua.com.goit.gojava7.kickstarter.dao.file.reader.CategoryFileReader;
import ua.com.goit.gojava7.kickstarter.dao.file.reader.ProjectFileReader;
import ua.com.goit.gojava7.kickstarter.dao.file.reader.QuestionFileReader;
import ua.com.goit.gojava7.kickstarter.dao.file.reader.QuoteFileReader;
import ua.com.goit.gojava7.kickstarter.dao.file.reader.RewardFileReader;
import ua.com.goit.gojava7.kickstarter.dao.memory.CategoryMemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.memory.ProjectMemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuestionMemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuoteMemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.memory.RewardMemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.memory.reader.Memory;

public class DaoFactory {

	private QuoteDao quoteDAO;
	private CategoryDao categoryDAO;
	private ProjectDao projectDAO;
	private QuestionDao questionDAO;
	private RewardDao rewardDAO;

	private static final File QUOTES_FILE = new File("./resources/Quotes.txt");
	private static final File CATEGORIES_FILE = new File("./resources/Categories.txt");
	private static final File PROJECTS_FILE = new File("./resources/Projects.txt");
	private static final File REWARDS_FILE = new File("./resources/Rewards.txt");
	private static final File QUESTIONS_FILE = new File("./resources/Questions.txt");
	private MyDataSource dataSource;

	//private Connection connection = null;

	public DaoFactory(MyDataSource dataSource) {
		this.dataSource = dataSource;

		switch (dataSource) {
		case MEMORY:
			initMemoryStorage();
			break;

		case FILE:
			initFileStorage();
			break;

		case DB:
			initDbStorage();
			break;

		default:
			break;
		}
	}

	public static BasicDataSource setupDataSource(String dbDriver, String dbURL, String user, String password) {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(dbDriver);
		ds.setUrl(dbURL);
		ds.setUsername(user);
		ds.setPassword(password);
		return ds;
	}

	public Connection open() {
		Connection connection = null;
		if (dataSource == MyDataSource.DB) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				DataSource dataSource = setupDataSource("com.mysql.jdbc.Driver",
						"jdbc:mysql://localhost:3306/kickstarter", "root", "temppassword");
				connection = dataSource.getConnection();
			} catch (SQLException e) {
				throw new IllegalStateException("Cannot open connection. " + e.getMessage(), e);
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException("Cannot open load mysql driver. " + e.getMessage(), e);
			}
		}
		return connection;
	}

	public void close() {
		//if (dataSource == MyDataSource.DB) {
			//try {
				//if (connection != null) {
				//	connection.close();
			//	}
			//} catch (SQLException e) {
			//	throw new IllegalStateException("Cannot close connection " + connection + ". " + e.getMessage(), e);
			//}
		//}
	}

	private void initMemoryStorage() {
		Memory data = new Memory();

		quoteDAO = new QuoteMemoryDao(data.getQuotes());
		categoryDAO = new CategoryMemoryDao(data.getCategories());
		projectDAO = new ProjectMemoryDao(data.getProjects());
		questionDAO = new QuestionMemoryDao(data.getQuestions());
		rewardDAO = new RewardMemoryDao(data.getRewards());
	}

	private void initFileStorage() {
		quoteDAO = new QuoteFileDao((new QuoteFileReader(QUOTES_FILE)).read());
		categoryDAO = new CategoryFileDao((new CategoryFileReader(CATEGORIES_FILE)).read());
		projectDAO = new ProjectFileDao((new ProjectFileReader(PROJECTS_FILE)).read());
		rewardDAO = new RewardFileDao((new RewardFileReader(REWARDS_FILE)).read());
		questionDAO = new QuestionsFileDao((new QuestionFileReader(QUESTIONS_FILE)).read());
	}

	private void initDbStorage() {
		open();
		quoteDAO = new QuoteDbDao(setupDataSource("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/kickstarter", "root", "temppassword"));
		categoryDAO = new CategoryDbDao(setupDataSource("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/kickstarter", "root", "temppassword"));
		projectDAO = new ProjectDbDao(setupDataSource("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/kickstarter", "root", "temppassword"));
		questionDAO = new QuestionDbDao(setupDataSource("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/kickstarter", "root", "temppassword"));
		rewardDAO = new RewardDbDao(setupDataSource("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/kickstarter", "root", "temppassword"));
	}

	public CategoryDao getCategoryDAO() {
		return categoryDAO;
	}

	public QuoteDao getQuoteDAO() {
		return quoteDAO;
	}

	public ProjectDao getProjectDAO() {
		return projectDAO;
	}

	public QuestionDao getQuestionDAO() {
		return questionDAO;
	}

	public RewardDao getRewardDAO() {
		return rewardDAO;
	}

}
