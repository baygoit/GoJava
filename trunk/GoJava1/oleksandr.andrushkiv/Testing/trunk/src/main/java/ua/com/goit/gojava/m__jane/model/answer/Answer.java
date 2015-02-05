package ua.com.goit.gojava.m__jane.model.answer;

import ua.com.goit.gojava.m__jane.model.question.Question;

public abstract class Answer {
	
	private Question question;
	private AnswerStatus answerStatus;

	public AnswerStatus getStatusUserAnswer() {
		return answerStatus;
	}

	public void setStatusUserAnswer(AnswerStatus answerStatus) {
		this.answerStatus = answerStatus;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}


	public abstract void checkAnswer();
	
}
