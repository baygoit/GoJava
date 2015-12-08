package ua.com.goit.gojava7.kickstarter.dao;

import java.io.InputStream;
import java.util.Properties;

import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.CategoryPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.PaymentPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.ProjectPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.QuestionPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.QuotePostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.RewardPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDispatcher;
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
	private JdbcDispatcher dispatcher;

	public StorageFactory() {
		
	}
	
	public StorageFactory(DataType dataType, Properties properties) {
		this.dataType = dataType;
		this.properties = properties;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public void setDispatcher(JdbcDispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	public StorageFactory(DataType dataType) {
		this(dataType, "./src/main/resources/config.properties");
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

	private JdbcDispatcher getDispatcher() {
		if (dispatcher == null) {
			try {
				Class.forName(properties.getProperty("driver"));
				dispatcher = new JdbcDispatcher(properties.getProperty("driver"), properties.getProperty("url"), properties.getProperty("user"),
						properties.getProperty("password"));
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
			quoteDAO = new QuotePostgreDAO(getDispatcher());
		}
		return quoteDAO;
	}

	public CategoryDAO getCategoryDAO() {
		if (categoryDAO == null) {
			categoryDAO = new CategoryPostgreDAO(getDispatcher());
		}
		return categoryDAO;
	}

	public ProjectDAO getProjectDAO() {
		if (projectDAO == null) {
			projectDAO = new ProjectPostgreDAO(getDispatcher());
		}
		return projectDAO;
	}

	public QuestionsDAO getQuestionsDAO() {
		if (questionsDAO == null) {
			questionsDAO = new QuestionPostgreDAO(getDispatcher());
		}
		return questionsDAO;
	}

	public PaymentDAO getPaymentDAO() {
		if (paymentDAO == null) {
			paymentDAO = new PaymentPostgreDAO(getDispatcher());
		}
		return paymentDAO;
	}

	public RewardDAO getRewardDAO() {
		if (rewardDAO == null) {
			rewardDAO = new RewardPostgreDAO(getDispatcher());
		}
		return rewardDAO;
	}
}
