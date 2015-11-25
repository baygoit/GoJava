package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.MemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionStorage;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionMemoryDao extends MemoryDao<Question> implements QuestionStorage {
	
	public QuestionMemoryDao(List<Question> data) {
		super(data);
	}
	
}
