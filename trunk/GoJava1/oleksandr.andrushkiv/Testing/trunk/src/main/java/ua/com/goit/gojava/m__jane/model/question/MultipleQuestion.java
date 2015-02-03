package ua.com.goit.gojava.m__jane.model.question;

import java.util.List;

import ua.com.goit.gojava.m__jane.model.answer.Answer;
import ua.com.goit.gojava.m__jane.model.answer.MultipleAnswer;


public class MultipleQuestion extends Question {

	private List<PredefinedAnswer> variantAnwerList;
	
	public List<PredefinedAnswer> getVariantAnwerList() {
		return variantAnwerList;
	}

	public void setVariantAnwerList(List<PredefinedAnswer> variantAnwerList) {
		this.variantAnwerList = variantAnwerList;
	}

	@Override
	public String toString() {
		return "ClosedQuestion [getContent()=" + getContent() + "]";
	}

	@Override
	public Answer createTemplateAnswer() {
		Answer answer = new MultipleAnswer();
		answer.setQuestion(this);
		return answer;
	}

}
