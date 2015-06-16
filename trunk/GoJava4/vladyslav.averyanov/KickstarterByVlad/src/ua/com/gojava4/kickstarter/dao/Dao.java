package ua.com.gojava4.kickstarter.dao;

import java.sql.SQLException;

public interface Dao extends QuotesDao, CategoriesDao, ProjectsDao,
		QuestionsAndAnswersDao, PaymentsDao {
	
	void initData() throws SQLException;
	
}
