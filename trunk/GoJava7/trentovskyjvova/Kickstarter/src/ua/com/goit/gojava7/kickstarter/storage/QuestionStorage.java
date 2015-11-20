package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionStorage {
	private List<Question> questions = new ArrayList<>();

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public int generateIdOfNewElement() {
		int maxId = 0;
		for (Question question : questions) {
			if (maxId < question.getId()) {
				maxId = question.getId();
			}
		}
		return maxId + 1;

	}

	public void addQuestion(Question question) {
		questions.add(question);		
	}
	
}
