package kickstarter.model.dao;

import kickstarter.exception.CannotAddDataException;
import kickstarter.exception.CannotCreateTableException;

public interface QuestionsDAO {
	void addQuestion(int projectId, String question) throws CannotAddDataException;

	void createTableQuestions() throws CannotCreateTableException;
}
