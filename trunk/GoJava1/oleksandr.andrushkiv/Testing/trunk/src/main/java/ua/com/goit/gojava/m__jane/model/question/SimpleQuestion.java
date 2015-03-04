package ua.com.goit.gojava.m__jane.model.question;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import ua.com.goit.gojava.m__jane.model.answer.Answer;
import ua.com.goit.gojava.m__jane.model.answer.SimpleAnswer;


@XmlAccessorType(XmlAccessType.FIELD)
public class SimpleQuestion extends Question {

	@XmlAttribute
	private String standartAnswer;

	public String getStandartAnswer() {
		return standartAnswer;
	}

	public void setStandartAnswer(String standartAnswer) {
		this.standartAnswer = standartAnswer;
	}

	@Override
	public String toString() {

		return new StringBuilder()	
				.append("SimpleQuestion [")
				.append("id=").append(getId())
				.append(", content=").append(getContent())
				.append(", standartAnswer=").append(standartAnswer)
				.append("]").toString();
	}

	//@Override
	public Answer createTemplateAnswer() {
		Answer answer = new SimpleAnswer();
		answer.setQuestion(this);
		return answer;
	}
}
