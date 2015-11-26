package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionDaoMemoryImpl implements QuestionDao {
	private List<Question> questions;

	@Override
	public List<Question> getQuestions(int projectId) {
		cacheQuestions();

		List<Question> projectQuestions = new ArrayList<>();

		for (Question question : questions) {
			if (projectId == question.getProjectId()) {
				projectQuestions.add(question);
			}
		}
		return projectQuestions;
	}

	@Override
	public void addQuestion(Question question) {
		questions.add(question);
	}

	@Override
	public int generateIdOfNewElement() {
		initQuestions();

		int maxId = 0;
		for (Question question : questions) {
			if (maxId < question.getId()) {
				maxId = question.getId();
			}
		}
		return maxId + 1;
	}

	public void cacheQuestions() {
		if (questions == null) {
			initQuestions();
		}
	}

	public void initQuestions() {
		if (questions == null) {

			questions = new ArrayList<>();

			Question question1 = new Question(1);
			question1.setProjectId(1);
			question1.setQuestionText("What the heck is going on?");
			
			questions.add(question1);
			
		}
	}
}
