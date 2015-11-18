package ua.com.goit.gojava7.kickstarter.domain;

public class Question {
	private String question = "";
	private String answer = "";
	private String time = "";
	
	public Question() {		
		
	}
	
	public Question(String time, String question) {		
		this.time = time;	
		this.question = question;	
		this.answer = "There is no answer yet";
	}
	
	public Question(String time, String question, String answer) {	
		this.time = time;	
		this.question = question;
		this.answer = answer;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answear) {
		this.answer = answear;
	}

}
