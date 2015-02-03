package ua.com.goit.gojava.m__jane.model.question;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import ua.com.goit.gojava.m__jane.model.answer.Answer;
import ua.com.goit.gojava.m__jane.model.answer.SimpleAnswer;


@XmlAccessorType(XmlAccessType.FIELD)
public class SimpleQuestion extends Question {

	private String standartAnswer;


	public String getStandartAnswer() {
		return standartAnswer;
	}

	public void setStandartAnswer(String standartAnswer) {
		this.standartAnswer = standartAnswer;
	}

	@Override
	public String toString() {
		return "OpenQuestion [getContent()=" + getContent() + "]";
	}

	@Override
	public Answer createTemplateAnswer() {
		Answer answer = new SimpleAnswer();
		answer.setQuestion(this);
		return answer;
	}
}
