package ua.com.goit.gojava7.kickstarter.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.db.CategoryDbDao;
import ua.com.goit.gojava7.kickstarter.dao.db.ProjectDbDao;
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
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuestionStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.RewardStorage;

public class DaoFactory {

	private QuoteStorage quoteDAO;
	private CategoryStorage categoryDAO;
	private ProjectStorage projectDAO;
	private QuestionStorage questionsDAO;
	private RewardStorage rewardDAO;

	private static final File QUOTES_FILE = new File("./resources/Quotes.txt");
	private static final File CATEGORIES_FILE = new File("./resources/Categories.txt");
	private static final File PROJECTS_FILE = new File("./resources/Projects.txt");
	private static final File REWARDS_FILE = new File("./resources/Rewards.txt");
	private static final File QUESTIONS_FILE = new File("./resources/Questions.txt");
	private DataSource dataSource;

	private Connection connection = null;

	public DaoFactory(DataSource dataSource) {
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
		questionsDAO = new QuestionMemoryDao(data.getQuestions());
		rewardDAO = new RewardMemoryDao(data.getRewards());
	}

	private void initFileStorage() {
		quoteDAO = new QuoteFileDao((new QuoteFileReader(QUOTES_FILE)).read());
		categoryDAO = new CategoryFileDao((new CategoryFileReader(CATEGORIES_FILE)).read());
		projectDAO = new ProjectFileDao((new ProjectFileReader(PROJECTS_FILE)).read());
		rewardDAO = new RewardFileDao((new RewardFileReader(REWARDS_FILE)).read());
		questionsDAO = new QuestionsFileDao((new QuestionFileReader(QUESTIONS_FILE)).read());
		// TODO
		// questionsDAO = new QuestionsFileDao(mem.getQuestions());
	}

	private void initDbStorage() {
		open();
		quoteDAO = new QuoteDbDao(connection);
		categoryDAO = new CategoryDbDao(connection);
		projectDAO = new ProjectDbDao(connection);
		// questionsDAO = new QuestionsMemoryDao(data.getQuestions());
		rewardDAO = new RewardDbDao(connection);
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

	public QuestionStorage getQuestionsDAO() {
		return questionsDAO;
	}

	public RewardStorage getRewardDAO() {
		return rewardDAO;
	}

}
