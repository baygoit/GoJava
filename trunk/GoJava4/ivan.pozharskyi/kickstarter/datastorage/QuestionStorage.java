package com.ivanpozharskyi.kickstarter.datastorage;

public class QuestionStorage {
	private static final int MAX_QUESTION_AMOUNT = 9;
	private int size = 0;
	private Question[] questions = new Question[MAX_QUESTION_AMOUNT];

	protected QuestionStorage(Question[] questions) {
		this.questions = questions;
	}

	protected QuestionStorage() {

	}
	
	protected void addQustion(Question question) {
		questions[size++] = question;
	}
	
	public Question getQuestion(int index){
		return questions[index];
	}
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < size; i++) {
			result = result + "" + questions[i];
		}
		return result;
	}

}
