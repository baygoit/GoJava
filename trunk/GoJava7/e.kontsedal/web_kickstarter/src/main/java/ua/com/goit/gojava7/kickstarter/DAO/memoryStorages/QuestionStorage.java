package ua.com.goit.gojava7.kickstarter.DAO.memoryStorages;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractQuestionStorage;
import ua.com.goit.gojava7.kickstarter.model.Question;

public class QuestionStorage extends AbstractQuestionStorage{

	private static int idGenerator = 0;
	private List<Question> questions;

	public QuestionStorage() {
		questions = new ArrayList<>();
	}

	public List<Question> getQuestionsFromSelectedProject(int idProject) {
		List<Question> questionsInProject = new ArrayList<>();
		for (Question question : questionsInProject) {
			if (question.getIdParentProject() == idProject) {
				questionsInProject.add(question);
			}
		}
		return questionsInProject;
	}
	
	@Override
	public List<Question> getAll() {
		return questions;
	}

	@Override
	public void add(Question question) {
		question.setIdQuestion(++idGenerator);
		questions.add(question);
	}
	
}
