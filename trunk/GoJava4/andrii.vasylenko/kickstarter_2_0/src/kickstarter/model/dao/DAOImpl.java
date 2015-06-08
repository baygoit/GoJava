package kickstarter.model.dao;

import java.sql.SQLException;
import java.util.List;

import kickstarter.exception.NoSuchDataException;
import kickstarter.model.engine.Category;
import kickstarter.model.engine.PaymentVariant;
import kickstarter.model.engine.Project;
import kickstarter.model.engine.Quote;

public class DAOImpl implements DAO {
	private ConnectionPool connectionPool;
	private QuotesDAO quotes;
	private CategoriesDAO categories;
	private ProjectsDAO projects;
	private QuestionsDAO questions;
	private PaymentsDAO payments;

	public DAOImpl(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
		initDAO();
	}

	@Override
	public void initData() throws SQLException {
		createTables();
		setDefaultsData();
	}

	@Override
	public void addQuote(String quote) throws SQLException {
		quotes.addQuote(quote);
	}

	@Override
	public Quote getRandomQuote() throws NoSuchDataException, SQLException {
		return quotes.getRandomQuote();
	}

	@Override
	public void createTableQuotes() throws SQLException {
		quotes.createTableQuotes();
	}

	@Override
	public void addCategory(String name) throws SQLException {
		categories.addCategory(name);
	}

	@Override
	public List<Category> getCategories() throws SQLException {
		return categories.getCategories();
	}

	@Override
	public Category getCategory(int id) throws NoSuchDataException, SQLException {
		return categories.getCategory(id);
	}

	@Override
	public void createTableCategories() throws SQLException {
		categories.createTableCategories();
	}

	@Override
	public void addProject(int categoryId, String name, String description, int totalAmount, int daysLeft,
			String history, String link) throws SQLException {
		projects.addProject(categoryId, name, description, totalAmount, daysLeft, history, link);
	}

	@Override
	public List<Project> getProjects(int categoryId) throws SQLException {
		return projects.getProjects(categoryId);
	}

	@Override
	public Project getProject(int id, int categoryId) throws NoSuchDataException, SQLException {
		return projects.getProject(id, categoryId);
	}

	@Override
	public void createTableProjects() throws SQLException {
		projects.createTableProjects();
	}

	@Override
	public void addQuestion(int projectId, String question) throws SQLException {
		questions.addQuestion(projectId, question);
	}

	@Override
	public void createTableQuestions() throws SQLException {
		questions.createTableQuestions();
	}

	@Override
	public void addPaymentVariant(int projectId, int amount, String description) throws SQLException {
		payments.addPaymentVariant(projectId, amount, description);
	}

	@Override
	public void donate(int projectId, int amount) throws SQLException {
		payments.donate(projectId, amount);
	}

	@Override
	public List<PaymentVariant> getPaymentVariants(int projectId) throws SQLException {
		return payments.getPaymentVariants(projectId);
	}

	@Override
	public PaymentVariant getPaymentVariant(int id, int projectId) throws NoSuchDataException, SQLException {
		return payments.getPaymentVariant(id, projectId);
	}

	@Override
	public void createTablePayments() throws SQLException {
		payments.createTablePayments();
	}

	private void initDAO() {
		quotes = new QuotesDAOImpl(connectionPool);
		categories = new CategoriesDAOImpl(connectionPool);
		projects = new ProjectsDAOImpl(connectionPool);
		questions = new QuestionsDAOImpl(connectionPool);
		payments = new PaymentsDAOImpl(connectionPool);
	}

	private void createTables() throws SQLException {
		createTableQuotes();
		createTableCategories();
		createTableProjects();
		createTableQuestions();
		createTablePayments();
	}

	private void setDefaultsData() throws SQLException {
		addQuote("Don't cry because it's over, smile because it happened");
		addQuote("Be yourself; everyone else is already taken.");
		addQuote("A room without books is like a body without a soul.");

		addCategory("Sport");
		addCategory("Business");

		addProject(1, "velo parking", "velo parking in Kiev", 10000, 100, "History1", "www.project1.com");
		addProject(1, "velo track", "velo track in Kiev", 100000, 200, "History2", "www.project2.com");
		addProject(2, "IT-school", "IT - future of Ukraine", 1000000, 1000, "History3", "www.project3.com");

		donate(1, 500);
		donate(2, 5000);
		donate(3, 50000);

		addPaymentVariant(1, 10, "minimum");
		addPaymentVariant(1, 100, "medium");
		addPaymentVariant(1, 500, "high");
		addPaymentVariant(2, 10000, "standart");
		addPaymentVariant(3, 50000, "standart");

		addQuestion(1, "WTF ¹1?");
		addQuestion(2, "WTF ¹2?");
		addQuestion(3, "WTF ¹3?");
	}
}
