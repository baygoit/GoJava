package kickstarter.model.dao;

import java.sql.SQLException;

public interface QuestionsDAO {
	void addQuestion(int projectId, String question) throws SQLException;

	void createTableQuestions() throws SQLException;
}
