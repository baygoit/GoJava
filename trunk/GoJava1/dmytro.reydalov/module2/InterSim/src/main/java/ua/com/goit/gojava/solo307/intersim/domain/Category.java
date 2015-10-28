package ua.com.goit.gojava.solo307.intersim.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Category {

	private int id;
	private String name;
	private List<Question> questions = new ArrayList<Question>();

	public Category(int id, String name, List<Question> questions) {
		this.id = id;
		this.name = name;
		this.questions = questions;
	}

	public Category(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void addQuestion(Question question) {
		questions.add(question);
	}

	public void addQuestions(List<Question> questions) {
		for (Question question : questions) {
			this.questions.add(new Question(question.getText(), question
					.getAnswers(), question.getId(), question.getCategoryId()));
		}
	}

	public List<String> getQuestionsAndAnswers() {
		List<String> questionsAndAnswers = new ArrayList<String>();
		for (Question question : questions) {
			questionsAndAnswers.add(question.getText() + "\n");
			for (Answer answer : question.getAnswers()) {
				questionsAndAnswers.add(answer.getText());
			}
		}
		return questionsAndAnswers;
	}

	public Set<Integer> parseIds(String[] answers) {
		Set<Integer> ids = new HashSet<Integer>();
		for (String answerId : answers) {
			int id = Integer.parseInt(answerId);
			ids.add(new Integer(id));
		}
		return ids;
	}

	public Set<Question> getQuestionsById(Set<Integer> answerIds) {
		Set<Question> reconstructed = new HashSet<Question>();
		for (Question question : questions) {
			for (Integer id : answerIds) {
				if (question.hasNextId(id)) {
					Answer answer = null;
					try {
						answer = question.findAnswerById(id);
					} catch (InterviewSimulatorDomainException e) {
						e.getMessage();
						e.printStackTrace();
					}
					question.addMarkedAnswer(answer);
					reconstructed.add(question);
				}
			}
		}
		return reconstructed;
	}

	public void evaluateMarks(Set<Question> reconstructed) {
		for (Question question : questions) {
			question.evaluateMark();
			Mark mark = question.getMark();
			question.setMark(mark);
		}
	}
}
