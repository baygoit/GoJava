package kickstarter.model.dao.sub;

import java.sql.SQLException;

import kickstarter.exception.DataBaseException;

public interface QuestionsDAO {
	/**
	 * add new Question for project to DB
	 */
	void addQuestion(int projectId, String question) throws DataBaseException, SQLException;

	/**
	 * create table Questions in DB
	 */
	void createTableQuestions() throws DataBaseException, SQLException;
}
