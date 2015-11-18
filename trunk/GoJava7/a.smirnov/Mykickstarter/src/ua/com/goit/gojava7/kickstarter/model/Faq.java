package ua.com.goit.gojava7.kickstarter.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Faq implements Serializable {

	private static final long serialVersionUID = 1L;
	private String question;
	private String answer;
	private Calendar receivedQuestionDate;
	private int projectID;
	
	public Faq(String question) {
		this.question = question;
		setReceivedQuestionDay();
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
	
	public Calendar getReceivedQuestionDay() {
		return receivedQuestionDate;
	}
	
	public int getProjectID() {
		return projectID;
	}
	
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	protected void setReceivedQuestionDay() {
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Kiev");
		receivedQuestionDate = Calendar.getInstance();
		Date date = new Date();
		receivedQuestionDate.setTimeZone(timeZone);
		receivedQuestionDate.setTime(date);
	}
}
