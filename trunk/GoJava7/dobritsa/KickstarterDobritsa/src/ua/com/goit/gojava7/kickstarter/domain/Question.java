package ua.com.goit.gojava7.kickstarter.domain;

public class Question {
	private String question;
	private String answer;
	
	public Question(String question, String answer) {		
		this.question = question;
		this.answer = answer;
	}
	
	public Question(String question) {		
		this.question = question;	
		this.answer = "There is no answer";
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswear() {
		return answer;
	}

	public void setAnswear(String answear) {
		this.answer = answear;
	}

}
