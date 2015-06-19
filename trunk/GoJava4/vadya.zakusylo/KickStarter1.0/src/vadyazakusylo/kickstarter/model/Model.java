package vadyazakusylo.kickstarter.model;

import java.util.List;

import vadyazakusylo.kickstarter.model.dao.CategoriesDao;
import vadyazakusylo.kickstarter.model.dao.ProjectDao;
import vadyazakusylo.kickstarter.model.dao.ProjectsDao;
import vadyazakusylo.kickstarter.model.dao.QuotesDao;

public class Model {
	private QuotesDao quotesDao;
	private CategoriesDao categoriesDao;
	private ProjectsDao projectsDao;
	private ProjectDao projectDao;
	private Category categoryChosen;
	private Project projectChosen;

	public Model(QuotesDao quotesDao, CategoriesDao categoriesDao, ProjectsDao projectsDao,
			ProjectDao projectDao) {
		this.quotesDao = quotesDao;
		this.categoriesDao = categoriesDao;
		this.projectsDao = projectsDao;
		this.projectDao = projectDao;
	}

	public Quote getQuote() {
		List<Quote> quotes = getQuotesList();
		int randomQuote = (int) Math.round((Math.random() * (quotes.size() - 1)));
		return quotes.get(randomQuote);
	}

	private List<Quote> getQuotesList() {
		List<Quote> quotes = quotesDao.getQuotesList();
		return quotes;
	}

	public List<Category> getCategoriesList() {
		List<Category> categories = categoriesDao.getCategoriesList();
		return categories;
	}

	public void setCategoryChosen(Category category) {
		categoryChosen = category;
	}

	public Category getCategoryChosen() {
		return categoryChosen;
	}

	public List<Project> getProjectsList(Category category) {
		List<Project> projects = projectsDao.getProjectsList(category);
		return projects;
	}

	public Project getProject(String projectChosenName) {
		Project project =projectDao.getProject(projectChosenName);
		return project;
	}
	public void setProjectChosen(Project project) {
		projectChosen = project;
	}

	public Project getProjectChosen() {
		return projectChosen;
	}

	public void setCurrentMoney(double money) {
		money += projectDao.getCurrenMoney(projectChosen.getName());
		projectDao.setCurrentMoney(money, projectChosen.getName());
	}

	public void setQuestion(String question) {
		projectDao.setQuestion(question, projectChosen.getName());
	}
}
