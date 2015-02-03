package ua.com.goit.gojava.m__jane.model.answer;

import ua.com.goit.gojava.m__jane.model.question.Question;

public abstract class Answer {
	
	private Question question;
	private StatusAnswer statusAnswer;

	public StatusAnswer getStatusUserAnswer() {
		return statusAnswer;
	}

	public void setStatusUserAnswer(StatusAnswer statusAnswer) {
		this.statusAnswer = statusAnswer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}


	public abstract void checkAnswer();
	
}
