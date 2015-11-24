package ua.com.goit.gojava7.kickstarter.domain;

import java.util.Date;

public class Question {
	private String time = "";
	private String question = "";
	private String answer = "";
	private String projectName;

	public Question(String question) {
		this.time = new Date().toString();
		this.question = question;
		this.answer = "There is no answer yet";
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

	public String getQuestion() {
		return question;
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

}
