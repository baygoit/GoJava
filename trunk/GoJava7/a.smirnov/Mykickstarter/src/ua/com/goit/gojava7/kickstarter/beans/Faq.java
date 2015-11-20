package ua.com.goit.gojava7.kickstarter.beans;

import java.io.Serializable;

public class Faq implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int projectID;
	private String question;
	private String answer;
	
	public Faq(String question) {
		this.question = question;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public int getProjectID() {
		return projectID;
	}
	
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
}
