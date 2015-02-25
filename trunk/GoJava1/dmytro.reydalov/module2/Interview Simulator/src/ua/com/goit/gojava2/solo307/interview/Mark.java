package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.List;

public class Mark {
	
	private boolean isCorrect;
	private boolean isHalfcorrect;
	private boolean isIncorrect;
	private String questionText;
	private List<Answer> answers = new ArrayList<Answer>();
	
	public Mark() {
		isCorrect = false;
		isHalfcorrect = false;
		isIncorrect = false;
		questionText = "there must be a qustion text here";
	}

	public boolean isCorrect() {
		return isCorrect;
	}
	
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
	public boolean isHalfcorrect() {
		return isHalfcorrect;
	}
	
	public void setHalfcorrect(boolean isHalfcorrect) {
		this.isHalfcorrect = isHalfcorrect;
	}
	
	public boolean isIncorrect() {
		return isIncorrect;
	}
	
	public void setIncorrect(boolean isIncorrect) {
		this.isIncorrect = isIncorrect;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<String> getIncorrectAnswers(){
		List<String> status = new ArrayList<String>();
		if(isIncorrect)status.add(new String(questionText));
		for(Answer answer: answers){
			if(isIncorrect)status.add(new String(answer.getText()));
		}
		return status;
	}
}
