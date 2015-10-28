package kickstarter.model.dao;

import java.sql.SQLException;

public interface DAO extends QuotesDAO, CategoriesDAO, ProjectsDAO, QuestionsDAO, PaymentsDAO {
	void initData() throws SQLException;
}
