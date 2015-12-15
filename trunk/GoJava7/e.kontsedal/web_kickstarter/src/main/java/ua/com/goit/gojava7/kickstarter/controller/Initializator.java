package ua.com.goit.gojava7.kickstarter.controller;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractCategoryStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractPaymentStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractProjectStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractQuestionStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractQuoteStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql.CategoryDbStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql.PaymentDbStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql.ProjectDbStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql.QuestionDbStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql.QuoteDbStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.util.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.DAO.fileStorage.CategoryFileStorage;
import ua.com.goit.gojava7.kickstarter.DAO.fileStorage.PaymentFileStorage;
import ua.com.goit.gojava7.kickstarter.DAO.fileStorage.ProjectFileStorage;
import ua.com.goit.gojava7.kickstarter.DAO.fileStorage.QuestionFileStorage;
import ua.com.goit.gojava7.kickstarter.DAO.fileStorage.QuoteFileStorage;
import ua.com.goit.gojava7.kickstarter.DAO.memoryStorages.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.DAO.memoryStorages.PaymentStorage;
import ua.com.goit.gojava7.kickstarter.DAO.memoryStorages.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.DAO.memoryStorages.QuestionStorage;
import ua.com.goit.gojava7.kickstarter.DAO.memoryStorages.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.DAO.memoryStorages.util.Memory;

public class Initializator {

	private AbstractQuoteStorage quoteStorage;
	private AbstractCategoryStorage categoryStorage;
	private AbstractProjectStorage projectStorage;
	private AbstractPaymentStorage paymentStorage;
	private AbstractQuestionStorage questionStorage;

	public Initializator(String arg) {
		if (arg == "m") {
			initMemoryStorage();
		} else if (arg == "f") {
			initFileStorage();
		} else {
			initDbStorage();
		}
	}

	private void initMemoryStorage() {
		Memory memory = new Memory();
		quoteStorage = new QuoteStorage(memory.getQuotes());
		categoryStorage = new CategoryStorage(memory.getCategories());
		projectStorage = new ProjectStorage(memory.getProjects());
		paymentStorage = new PaymentStorage();
		questionStorage = new QuestionStorage();
	}

	private void initFileStorage() {
		quoteStorage = new QuoteFileStorage();
		categoryStorage = new CategoryFileStorage();
		projectStorage = new ProjectFileStorage();
		paymentStorage = new PaymentFileStorage();
		questionStorage = new QuestionFileStorage();
	}

	private void initDbStorage() {
		JdbcDispatcher dispatcher = new JdbcDispatcher();
		quoteStorage = new QuoteDbStorage(dispatcher);
		categoryStorage = new CategoryDbStorage(dispatcher);
		projectStorage = new ProjectDbStorage(dispatcher);
		paymentStorage = new PaymentDbStorage(dispatcher);
		questionStorage = new QuestionDbStorage(dispatcher);
	}

	public AbstractQuoteStorage getQuoteStorage() {
		return quoteStorage;
	}

	public AbstractCategoryStorage getCategoryStorage() {
		return categoryStorage;
	}

	public AbstractProjectStorage getProjectStorage() {
		return projectStorage;
	}

	public AbstractPaymentStorage getPaymentStorage() {
		return paymentStorage;
	}

	public AbstractQuestionStorage getQuestionStorage() {
		return questionStorage;
	}
}
