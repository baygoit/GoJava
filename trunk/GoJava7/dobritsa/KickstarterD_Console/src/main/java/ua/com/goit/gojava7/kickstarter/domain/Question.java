package ua.com.goit.gojava7.kickstarter.domain;

import java.util.Date;

public class Question {

	private int id;
	private String time = "";
	private String question = "";
	private String answer = "";
	private String projectName = "";
	private int projectId;

	public Question() {
		this.time = new Date().toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "Time: " + time + "; Question: " + question + "; Answer: " + answer + "; Project: " + projectName;
	}

}
