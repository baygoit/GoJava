package ua.com.goit.gojava7.kickstarter.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Faq implements Comparable<Faq>, Serializable {

	private static final long serialVersionUID = 1L;
	private Project project;
	private String question;
	private String answer;
	private Calendar receivedQuestionDate;
	
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
	
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}

	public Calendar getReceivedQuestionDay() {
		return receivedQuestionDate;
	}

	protected void setReceivedQuestionDay() {
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Kiev");
		receivedQuestionDate = Calendar.getInstance();
		Date date = new Date();
		receivedQuestionDate.setTimeZone(timeZone);
		receivedQuestionDate.setTime(date);
	}
	
	@Override
	public int compareTo(Faq that) {
		return  (int) (this.receivedQuestionDate.getTimeInMillis() - that.getReceivedQuestionDay().getTimeInMillis());
	}
}
