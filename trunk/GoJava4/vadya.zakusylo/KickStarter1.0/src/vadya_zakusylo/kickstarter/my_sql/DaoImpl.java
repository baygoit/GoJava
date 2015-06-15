package vadya_zakusylo.kickstarter.my_sql;

import vadya_zakusylo.kickstarter.model.dao.CategoriesDao;
import vadya_zakusylo.kickstarter.model.dao.Dao;
import vadya_zakusylo.kickstarter.model.dao.ProjectsDao;
import vadya_zakusylo.kickstarter.model.dao.QuotesDao;

public class DaoImpl implements Dao {
	private QuotesDao quotesDao;
	private CategoriesDao categoriesDao;
	private ProjectsDao projectsDao;

	public DaoImpl(QuotesDao quotesDao, CategoriesDao categoriesDao, ProjectsDao projectsDao) {
		this.quotesDao = quotesDao;
		this.categoriesDao = categoriesDao;
		this.projectsDao = projectsDao;
	}

	@Override
	public QuotesDao getQuotesDao() {
		return quotesDao;
	}

	@Override
	public CategoriesDao getCategoriesDao() {
		return categoriesDao;
	}

	@Override
	public ProjectsDao getProjectsDao() {
		return projectsDao;
	}
}
