package ua.com.goit.gojava.m__jane.model.question;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import ua.com.goit.gojava.m__jane.model.userAnswer.UserAnswer;
import ua.com.goit.gojava.m__jane.model.userAnswer.UserOpenAnswer;


@XmlAccessorType(XmlAccessType.FIELD)
public class OpenQuestion extends Question {

	private VariantAnwer variantAnwer;

	
	public VariantAnwer getVariantAnwer() {
		return variantAnwer;
	}

	public void setVariantAnwer(VariantAnwer variantAnwer) {
		this.variantAnwer = variantAnwer;
	}

	@Override
	public String toString() {
		return "OpenQuestion [getContent()=" + getContent() + "]";
	}

	@Override
	public UserAnswer createTemplateAnswer() {
		UserAnswer answer = new UserOpenAnswer();
		answer.setQuestion(this);
		return answer;
	}
}
