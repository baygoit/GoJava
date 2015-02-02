package ua.com.goit.gojava.m__jane.model.question;

import java.util.List;

import ua.com.goit.gojava.m__jane.model.userAnswer.UserAnswer;
import ua.com.goit.gojava.m__jane.model.userAnswer.UserClosedAnswer;


public class ClosedQuestion extends Question {

	private List<VariantAnwer> variantAnwerList;
	
	public List<VariantAnwer> getVariantAnwerList() {
		return variantAnwerList;
	}

	public void setVariantAnwerList(List<VariantAnwer> variantAnwerList) {
		this.variantAnwerList = variantAnwerList;
	}

	@Override
	public String toString() {
		return "ClosedQuestion [getContent()=" + getContent() + "]";
	}

	@Override
	public UserAnswer createTemplateAnswer() {
		UserAnswer answer = new UserClosedAnswer();
		answer.setQuestion(this);
		return answer;
	}

}
