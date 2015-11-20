package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.QuestionReader;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class MemoryQuestionReader implements QuestionReader {

	@Override
	public List<Question> readQuestions() {
		List<Question> questions = new ArrayList<>();
		
		Question question1 = new Question(1);
		question1.setProjectId(1);
		question1.setQuestionText("What the heck is going on?");
		questions.add(question1);
		
		return questions;
	}

}
