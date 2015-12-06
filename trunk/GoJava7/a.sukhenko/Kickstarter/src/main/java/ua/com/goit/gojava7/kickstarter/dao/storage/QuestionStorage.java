package ua.com.goit.gojava7.kickstarter.dao.storage;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Question;

public interface QuestionStorage extends Storage<Question>{
	public List<Question> getByProject(String projectName);

	public void add(Question question);

}
