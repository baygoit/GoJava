package com.gojava2.kickstarter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "faq")
public class FAQ {

	@Id
	@GeneratedValue
	private Integer id;

	private String question;

	private String answer;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	public Project getProject() {
		return project;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
}