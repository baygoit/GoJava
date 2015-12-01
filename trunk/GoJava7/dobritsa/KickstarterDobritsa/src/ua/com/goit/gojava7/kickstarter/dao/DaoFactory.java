package ua.com.goit.gojava7.kickstarter.dao;

import java.io.File;

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

	private static String dbDriver = "com.mysql.jdbc.Driver";
	private static String dbURL = "jdbc:mysql://localhost:3306/kickstarter";
	private static String user = "root";
	private static String password = "temppassword";

	public DaoFactory(MyDataSource dataSource) {
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

	/*public Connection open() {
	Connection connection = null;
		if (dataSource == MyDataSource.DB) {
			try {
				Class.forName(dbDriver);
				DataSource dataSource = setupDataSource(dbDriver, dbURL, user, password);
			connection = dataSource.getConnection();
			} catch (SQLException e) {
				throw new IllegalStateException("Cannot open connection. " + e.getMessage(), e);
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException("Cannot open load mysql driver. " + e.getMessage(), e);
			}
		}
		return connection;
	}*/

	/*public void close(DataSource ds) {
		if (dataSource == MyDataSource.DB) {
			BasicDataSource bds = (BasicDataSource) ds;
			try {

				bds.close();

			} catch (SQLException e) {
				throw new IllegalStateException("Cannot close connection " + bds + ". " + e.getMessage(), e);

			}
		}
	}*/

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
		quoteDAO = new QuoteDbDao(setupDataSource(dbDriver, dbURL, user, password));
		categoryDAO = new CategoryDbDao(setupDataSource(dbDriver, dbURL, user, password));
		projectDAO = new ProjectDbDao(setupDataSource(dbDriver, dbURL, user, password));
		questionDAO = new QuestionDbDao(setupDataSource(dbDriver, dbURL, user, password));
		rewardDAO = new RewardDbDao(setupDataSource(dbDriver, dbURL, user, password));
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
