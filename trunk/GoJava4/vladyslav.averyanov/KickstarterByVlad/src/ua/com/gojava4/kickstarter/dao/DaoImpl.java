package ua.com.gojava4.kickstarter.dao;

import java.sql.SQLException;
import java.util.*;

import ua.com.gojava4.kickstarter.entities.Answer;
import ua.com.gojava4.kickstarter.entities.Category;
import ua.com.gojava4.kickstarter.entities.Project;
import ua.com.gojava4.kickstarter.entities.Question;
import ua.com.gojava4.kickstarter.entities.Quote;

public class DaoImpl implements Dao { 
	
	private ConnectionPool connectionPoolDao;
	private QuotesDao quotesDao;
	private CategoriesDao categoriesDao;
	private ProjectsDao projectsDao;
	private QuestionsAndAnswersDao questionsAndAnswersDao;
	private PaymentsDao paymentsDao;

	public DaoImpl(ConnectionPool connectionPool) throws SQLException {
		this.connectionPoolDao = connectionPool;
		initDao();
	}

	private void initDao() throws SQLException {
		connectionPoolDao = new ConnectionPoolImpl();
		quotesDao = new QuotesDaoImpl(connectionPoolDao);
		categoriesDao = new CategoriesDaoImpl(connectionPoolDao);
		projectsDao = new ProjectsDaoImpl(connectionPoolDao);
		questionsAndAnswersDao = new QuestionsAndAnswersDaoImpl(connectionPoolDao);
		paymentsDao = new PaymentsDaoImpl(connectionPoolDao);
	}

	public List<Project> getAllProjectsOfCategory(int categoryId) {
		return projectsDao.getAllProjectsOfCategory(categoryId);
	}
	
	//mykola.stryebkov@gmail.com
	@Override
	public Quote getRandomQuote() {
		return quotesDao.getRandomQuote();				
	}

	@Override
	public Category getCategoryById(int categoryId) {
		return categoriesDao.getCategoryById(categoryId);
	}

	@Override
	public Map<Question, List<Answer>> getAllQuestionsAndAnswers() {
		return questionsAndAnswersDao.getAllQuestionsAndAnswers();
	}

	@Override
	public Map<Question, List<Answer>> getQuestionsAndAnswersForProject(
			Project project) {
		return questionsAndAnswersDao.getQuestionsAndAnswersForProject(project);
	}

	@Override
	public List<Answer> getAnswersForQuestion(Question question) {
		return questionsAndAnswersDao.getAnswersForQuestion(question);
	}

	@Override
	public void initData() throws SQLException {
		//some SQL for init
	}

	@Override
	public List<Category> getAllCategories() {
		return categoriesDao.getAllCategories();
	}

	@Override
	public List<Project> getAllProjects() {
		return projectsDao.getAllProjects();
	}
	
}
