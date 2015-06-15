package vadya_zakusylo.kickstarter.model;

import java.sql.Connection;
import java.util.List;

import vadya_zakusylo.kickstarter.model.dao.Dao;
import vadya_zakusylo.kickstarter.my_sql.CategoriesDaoImpl;
import vadya_zakusylo.kickstarter.my_sql.ProjectsDaoImpl;

public class ModelImpl implements Model {
	private Dao dao;
	private Category category;
	private Project project;
	private Connection connection; // to delete

	public ModelImpl(Connection connection, Dao dao) {
		// public ModelImpl(Dao dao) {
		this.dao = dao;
		this.connection = connection; // to delete
	}

	@Override
	public Quote getQuote() {
		List<Quote> quotes = selectQuotes();
		int randomQuote = (int) Math.round((Math.random() * (quotes.size() - 1)));
		return quotes.get(randomQuote);
	}

	private List<Quote> selectQuotes() {
		List<Quote> quotes = dao.getQuotesDao().getQuotesList();
		return quotes;
	}

	@Override
	public List<Category> selectCategories() {
		List<Category> categories = new CategoriesDaoImpl(connection).getCategoriesList(); // to
																							// delete
		// List<Category> categories = dao.getCategoriesDao().getCategoriesList();
		return categories;
	}

	@Override
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public Category getCategory() {
		return category;
	}

	@Override
	public List<Project> selectProjects(Category category) {
		List<Project> projects = new ProjectsDaoImpl(connection).getProjectsList(category); // to
																							// delete
		// List<Project> projects = dao.getProjectsDao().getProjectsList(category);
		return projects;
	}

	@Override
	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public Project getProject() {
		return project;
	}

	@Override
	public synchronized void setCurrentMoneySynchronized(double money) {
		money += dao.getProjectsDao().getCurrenMoney(project.getName());
		dao.getProjectsDao().setCurrentMoney(money, project.getName());
	}

	@Override
	public void setQuestion(String question) {
		dao.getProjectsDao().setQuestion(question, project.getName());
	}
}
