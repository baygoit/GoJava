package ua.com.goit.gojava7.kickstarter.config;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ua.com.goit.gojava7.kickstarter.dao.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.dao.QuestionsStorage;
import ua.com.goit.gojava7.kickstarter.dao.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.dao.RewardStorage;
import ua.com.goit.gojava7.kickstarter.dao.file.CategoryFileDao;
import ua.com.goit.gojava7.kickstarter.dao.file.CategoryFileReader;
import ua.com.goit.gojava7.kickstarter.dao.file.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.dao.file.ProjectFileDao;
import ua.com.goit.gojava7.kickstarter.dao.file.ProjectFileReader;
import ua.com.goit.gojava7.kickstarter.dao.file.QuoteFileDao;
import ua.com.goit.gojava7.kickstarter.dao.file.QuoteFileReader;
import ua.com.goit.gojava7.kickstarter.dao.memory.CategoryMemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.memory.Memory;
import ua.com.goit.gojava7.kickstarter.dao.memory.ProjectMemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuestionsMemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuoteMemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.memory.RewardMemoryDao;

public class DaoProvider {

	private QuoteStorage quoteDAO;
	private CategoryStorage categoryDAO;
	private ProjectStorage projectDAO;
	private QuestionsStorage questionsDAO;
	private RewardStorage rewardDAO;

	private static final File QUOTES_FILE = new File("./resources/Quotes.txt");
	private static final File CATEGORIES_FILE = new File("./resources/Categories.txt");
	private static final File PROJECTS_FILE = new File("./resources/Projects.txt");
	private DataSource dataSource;

	private Connection connection = null;

	public DaoProvider(DataSource dataSource) {
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

	public void open() {
		if (dataSource == DataSource.DB) {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kickstarter", "root",
						"temppassword");
			} catch (SQLException e) {
				throw new IllegalStateException("Cannot open connection. " + e.getMessage(), e);
			}
		}
	}

	public void close() {
		if (dataSource == DataSource.DB) {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new IllegalStateException("Cannot close connection " + connection + ". " + e.getMessage(), e);
			}
		}
	}

	private void initMemoryStorage() {
		Memory data = new Memory();
		quoteDAO = new QuoteMemoryDao(data.getQuotes());
		categoryDAO = new CategoryMemoryDao(data.getCategories());

		projectDAO = new ProjectMemoryDao(data.getProjects());
		questionsDAO = new QuestionsMemoryDao(data.getQuestions());
		rewardDAO = new RewardMemoryDao(data.getRewards());
	}

	private void initFileStorage() {
		QuoteFileReader quoteFileReader = new QuoteFileReader(QUOTES_FILE);
		quoteDAO = new QuoteFileDao(quoteFileReader.read());
		
		CategoryFileReader categoryFileReader = new CategoryFileReader(CATEGORIES_FILE);
		categoryDAO = new CategoryFileDao(categoryFileReader.read());

		ProjectFileReader projectFileReader = new ProjectFileReader(PROJECTS_FILE);
		projectDAO = new ProjectFileDao(projectFileReader.read());
		
		//projectDAO = new ProjectFileDao(mem.getProjects());
		//questionsDAO = new QuestionsFileDao(mem.getQuestions());
		//rewardDAO = new RewardFileDao(mem.getRewards());

	}

	private void initDbStorage() {
		// TODO Auto-generated method stub

	}

	public CategoryStorage getCategoryDAO() {
		return categoryDAO;
	}

	public QuoteStorage getQuoteDAO() {
		return quoteDAO;
	}

	public ProjectStorage getProjectDAO() {
		return projectDAO;
	}

	public QuestionsStorage getQuestionsDAO() {
		return questionsDAO;
	}

	public RewardStorage getRewardDAO() {
		return rewardDAO;
	}

}
