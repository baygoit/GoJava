package ua.com.goit.gojava7.kickstarter.model;

import java.io.Serializable;

public class Faq implements Comparable<Faq>, Serializable {

	private static final long serialVersionUID = 1L;
	private Project project;
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
	
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public int compareTo(Faq that) {
		return this.question.compareTo(that.getQuestion());
	}
}
