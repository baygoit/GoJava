package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Question;

public interface QuestionDao extends Dao<Question> {

	public List<Question> getByProject(String projectName); 
	public List<Question> getByProject(int projectId);
	public void add(Question question);

}
