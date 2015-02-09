package ua.com.goit.gojava.m__jane.model.question;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import ua.com.goit.gojava.m__jane.model.answer.Answer;
import ua.com.goit.gojava.m__jane.model.answer.MultipleAnswer;

@XmlAccessorType(XmlAccessType.FIELD)
public class MultipleQuestion extends Question {
	
	
	@XmlElement(name = "predefinedAnswer")
	@XmlElementWrapper(name = "predefinedAnswers")
	private List<PredefinedAnswer> predefinedAnwerList;
	
	public List<PredefinedAnswer> getPredefinedAnwerList() {
		return predefinedAnwerList;
	}

	public void setPredefinedAnwerList(List<PredefinedAnswer> predefinedAnwerList) {
		this.predefinedAnwerList = predefinedAnwerList;
	}

	@Override
	public String toString() {
		return "MultipleQuestion [getId() = " + getId() + ", getContent()=" + getContent() + ", predefinedAnwerList=" + predefinedAnwerList+"]";
	}

	//@Override
	public Answer createTemplateAnswer() {
		Answer answer = new MultipleAnswer();
		answer.setQuestion(this);
		return answer;
	}

}
