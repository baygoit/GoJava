package kickstarter.model.dao;

import java.sql.SQLException;

import kickstarter.exception.DataBaseException;
import kickstarter.model.dao.sub.CategoriesDAO;
import kickstarter.model.dao.sub.PaymentsDAO;
import kickstarter.model.dao.sub.ProjectsDAO;
import kickstarter.model.dao.sub.QuestionsDAO;
import kickstarter.model.dao.sub.QuotesDAO;

public interface DAO extends QuotesDAO, CategoriesDAO, ProjectsDAO, QuestionsDAO, PaymentsDAO {
	/**
	 * add create all tables in BD and add test data in the tables
	 */
	void initData() throws DataBaseException, SQLException;
}
