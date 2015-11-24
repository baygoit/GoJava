package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.QuestionsStorage;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionsMemoryDao extends QuestionsStorage {
	public QuestionsMemoryDao(List<Question> dataSource) {
		super();
	}
}
