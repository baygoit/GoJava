package com.anmertrix.domain;

public class Answer {
	
	private int id;
	private int questionId;
	private String answer;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public int getQuestionId() {
		return questionId;
	}
	
	public void setQuestionId(int question_id) {
		this.questionId = question_id;
	}

}
