package ua.com.goit.gojava.m__jane.model.userAnswer;

import ua.com.goit.gojava.m__jane.model.question.Question;
import ua.com.goit.gojava.m__jane.model.question.VariantAnwer;

public abstract class UserAnswer {
	
	private Question question;
	private StatusUserAnswer statusUserAnswer;
	private VariantAnwer variantAnwer;
	

	public StatusUserAnswer getStatusUserAnswer() {
		return statusUserAnswer;
	}

	public void setStatusUserAnswer(StatusUserAnswer statusUserAnswer) {
		this.statusUserAnswer = statusUserAnswer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public VariantAnwer getVariantAnwer() {
		return variantAnwer;
	}

	public void setVariantAnwer(VariantAnwer variantAnwer) {
		this.variantAnwer = variantAnwer;
	}	

}
