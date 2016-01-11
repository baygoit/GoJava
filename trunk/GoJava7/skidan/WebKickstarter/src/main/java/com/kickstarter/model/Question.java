package com.kickstarter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="questions")
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String question;
	@ManyToOne
	@JoinColumn(name = "projectId")
	private Project project;

	public Question() {

	}

	public Question(String question, Project project) {
		this.question = question;
		this.project = project;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String toString() {
		return question;
	}

}
