package ua.com.goit.gojava7.kickstarter.models;

import java.util.Date;

public class Question {

	private Long id;
	private String time = "";
	private String question = "";
	private String answer = "";
	private Long projectId;

	public Question() {
		this.time = new Date().toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public void setAnswer(String answear) {
		this.answer = answear;
	}
	
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "Time: " + time + "; Question: " + question + "; Answer: " + answer + "; projectId: " + projectId;
	}

}
