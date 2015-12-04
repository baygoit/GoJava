package ua.com.goit.gojava7.kickstarter.dao;

import java.io.InputStream;
import java.util.Properties;

import ua.com.goit.gojava7.kickstarter.dao.file.CategoryFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.PaymentFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.ProjectFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.QuestionFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.QuoteFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.RewardFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.CategoryPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.PaymentPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.ProjectPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.QuestionPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.QuotePostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.RewardPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.dao.memory.CategoryMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.PaymentMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.ProjectMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuestionMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuoteMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.RewardMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.util.Memory;
import ua.com.goit.gojava7.kickstarter.util.Utils;

public class StorageFactory {
	private DataType dataType;
	private QuoteDAO quoteDAO;
	private CategoryDAO categoryDAO;
	private ProjectDAO projectDAO;
	private QuestionsDAO questionsDAO;
	private PaymentDAO paymentDAO;
	private RewardDAO rewardDAO;
	private Properties properties;
	private Memory mem;
	private JdbcDispatcher dispatcher;

	public StorageFactory(DataType dataType, Properties properties) {
		this.dataType = dataType;
		this.properties = properties;
	}

	public StorageFactory(DataType dataType) {
		this(dataType, "./kicks-files/config.properties");
	}

	public StorageFactory(DataType dataType, String pathToFile) {
		this.dataType = dataType;
		properties = Utils.readProperties(pathToFile);
	}

	public StorageFactory(DataType dataType, InputStream resourceStream) {
		System.out.println("Storage created");
		this.dataType = dataType;
		properties = Utils.readProperties(resourceStream);
	}

	private Memory getMemory() {
		if (mem == null) {
			mem = new Memory();
		}
		return mem;
	}

	private JdbcDispatcher getDispatcher() {
		if (dispatcher == null) {
			try {
				Class.forName(properties.getProperty("driver"));
				dispatcher = new JdbcDispatcher(properties.getProperty("driver"), properties.getProperty("url"),
						properties.getProperty("user"), properties.getProperty("password"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dispatcher;
	}

	public DataType getDataType() {
		return dataType;
	}
	
	public void close() {
		if (dataType.equals(DataType.POSTGRE) && dispatcher != null) {
			dispatcher.close();
		}
	}

	public QuoteDAO getQuoteDAO() {
		if (quoteDAO == null) {
			switch (dataType) {
			case MEMORY:
				quoteDAO = new QuoteMemoryDAO(getMemory().getQuotes());
				break;
	
			case FILE:
				quoteDAO = new QuoteFileDAO();
				break;
	
			case POSTGRE:
				quoteDAO = new QuotePostgreDAO(getDispatcher());
				break;
	
			default:
				break;
			}
		}		
		return quoteDAO;
	}

	public CategoryDAO getCategoryDAO() {
		if (categoryDAO == null) {
			switch (dataType) {
			case MEMORY:
				categoryDAO = new CategoryMemoryDAO(getMemory().getCategories());
				break;

			case FILE:
				categoryDAO = new CategoryFileDAO();
				break;

			case POSTGRE:
				categoryDAO = new CategoryPostgreDAO(getDispatcher());
				break;

			default:
				break;
			}
		}
		return categoryDAO;
	}

	public ProjectDAO getProjectDAO() {
		if (projectDAO == null) {
			switch (dataType) {
			case MEMORY:
				projectDAO = new ProjectMemoryDAO(getMemory().getProjects());
				break;

			case FILE:
				projectDAO = new ProjectFileDAO();
				break;

			case POSTGRE:
				projectDAO = new ProjectPostgreDAO(getDispatcher());
				break;

			default:
				break;
			}
		}
		return projectDAO;
	}

	public QuestionsDAO getQuestionsDAO() {
		if (questionsDAO == null) {
			switch (dataType) {
			case MEMORY:
				questionsDAO = new QuestionMemoryDAO(getMemory().getQuestions());
				break;

			case FILE:
				questionsDAO = new QuestionFileDAO();
				break;

			case POSTGRE:
				questionsDAO = new QuestionPostgreDAO(getDispatcher());
				break;

			default:
				break;
			}
		}
		return questionsDAO;
	}

	public PaymentDAO getPaymentDAO() {
		if (paymentDAO == null) {
			switch (dataType) {
			case MEMORY:
				paymentDAO = new PaymentMemoryDAO(getMemory().getPayments());
				break;

			case FILE:
				paymentDAO = new PaymentFileDAO();
				break;

			case POSTGRE:
				paymentDAO = new PaymentPostgreDAO(getDispatcher());
				break;

			default:
				break;
			}
		}
		return paymentDAO;
	}

	public RewardDAO getRewardDAO() {
		if (rewardDAO == null) {
			switch (dataType) {
			case MEMORY:
				rewardDAO = new RewardMemoryDAO(getMemory().getRewards());
				break;

			case FILE:
				rewardDAO = new RewardFileDAO();
				break;

			case POSTGRE:
				rewardDAO = new RewardPostgreDAO(getDispatcher());
				break;

			default:
				break;
			}
		}
		return rewardDAO;
	}
}
