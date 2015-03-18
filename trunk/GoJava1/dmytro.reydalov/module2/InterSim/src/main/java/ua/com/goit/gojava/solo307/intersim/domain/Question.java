package ua.com.goit.gojava.solo307.intersim.domain;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.solo307.intersim.commons.ApplicationContextProvider;

public class Question {

	final int ZERO = 0;
	private int id;
	private int categoryId;
	private String text;
	private List<Answer> answers = new ArrayList<Answer>();
	private List<Answer> markedAnswers = new ArrayList<Answer>();
	private Mark mark;

	public Question() {
		this.text = "there is a question must be here...";
	}

	public Question(String text, List<Answer> answers, int id, int categoryId) {
		this.text = text;
		this.answers = answers;
		this.id = id;
		this.mark = (Mark) ApplicationContextProvider.getBean("mark");
		this.categoryId = categoryId;
	}

	public Question(String text, int id, int categoryId) {
		this.text = text;
		this.id = id;
		this.mark = (Mark) ApplicationContextProvider.getBean("mark");
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getText() {
		return text;
	}

	public void setText(String question) {
		this.text = question;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public List<Answer> getMarkedAnswers() {
		return markedAnswers;
	}

	public void addMarkedAnswer(Answer answer) {
		markedAnswers.add(answer);
	}

	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}

	public void addAnswers(List<Answer> answers) {
		this.answers.addAll(answers);
	}

	public void addAnswer(Answer answer) {
		this.answers.add(answer);
	}

	public boolean hasNextId(int answeredId) {
		for (Answer answer : answers) {
			if (answer.getId() == answeredId) {
				return true;
			}
		}
		return false;
	}

	public Answer findAnswerById(int id)
			throws InterviewSimulatorDomainException {
		for (Answer answer : answers) {
			if (answer.getId() == id)
				return answer;
		}
		throw new InterviewSimulatorDomainException(
				"no such answer id in question");
	}

	public void evaluateMark() {
		int counter = countMarkedCorrectAnswers();
		final int CORRECT_ANSWERS = countCorrectAnswers();
		if (counter > ZERO && counter < CORRECT_ANSWERS
				|| counter > CORRECT_ANSWERS)
			mark.setHalfcorrect(true);
		else if (counter == ZERO)
			mark.setIncorrect(true);
		else if (counter == CORRECT_ANSWERS)
			mark.setCorrect(true);
	}

	public int countMarkedCorrectAnswers() {
		int counter = ZERO;
		for (Answer answer : markedAnswers) {
			if (answer.isAnswerCorrect())
				counter++;
		}
		return counter;
	}

	public int countCorrectAnswers() {
		int counter = 0;
		for (Answer answer : answers) {
			if (answer.isAnswerCorrect())
				counter++;
		}
		return counter;
	}

	public boolean hasIncorrectAnswer() {
		for (Answer answer : markedAnswers) {
			if (!answer.isAnswerCorrect())
				return true;
		}
		return false;
	}
}
