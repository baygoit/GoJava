package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.dao.MemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuestionStorage;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionMemoryDao extends MemoryDao<Question> implements QuestionStorage{

	public QuestionMemoryDao(List<Question> data) {
		super(data);
	}

	@Override
	public List<Question> getByProject(String projectName) {
		return this.getAll().stream().filter(question -> question.getProjectName().equals(projectName))
				.collect(Collectors.toList());
	}

}
