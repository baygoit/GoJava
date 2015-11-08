package ua.com.gojava4.kickstarter.dao;

import java.util.List;
import java.util.Map;

import ua.com.gojava4.kickstarter.entities.Answer;
import ua.com.gojava4.kickstarter.entities.Project;
import ua.com.gojava4.kickstarter.entities.Question;

public interface QuestionsAndAnswersDao {
	
	Map<Question, List<Answer>> getAllQuestionsAndAnswers();
	
	Map<Question, List<Answer>> getQuestionsAndAnswersForProject(Project project);
	
	List<Answer> getAnswersForQuestion(Question question);
}
