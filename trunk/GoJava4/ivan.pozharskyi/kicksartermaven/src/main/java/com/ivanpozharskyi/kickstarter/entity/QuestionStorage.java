package com.ivanpozharskyi.kickstarter.entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class QuestionStorage {


	private Map<Question, ArrayList<Answer>> questionAndAnswers = new HashMap<Question, ArrayList<Answer>>();


	

	public QuestionStorage() {
		
	}

	public QuestionStorage(Question question, ArrayList<Answer> answer) {
		questionAndAnswers.put(question, answer);
	}

	public void addQustion(Question question) {
		questionAndAnswers.put(question, null);
	}

	public Question getQuestion(int id) {
		
		for(Question question:questionAndAnswers.keySet()){
			if(question.getId() == id){
				return question;
			}
		}
		return null;
	}
	public void addAnswers(ArrayList<Answer> answers,Question question){
		for(Map.Entry<Question, ArrayList<Answer>> entry: questionAndAnswers.entrySet()){
			if(entry.getKey().equals(question)){
				entry.setValue(answers);
			}
		}
	}
	public ArrayList<Answer> getAnswersOnQuestion(Question question){
		for(Map.Entry<Question, ArrayList<Answer>> entry: questionAndAnswers.entrySet()){
			if(entry.getKey().equals(question)){
				return entry.getValue();
			}
		}
	
		return null;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Map.Entry<Question, ArrayList<Answer>> entry: questionAndAnswers.entrySet()){
			result.append(entry.getKey().toString());
			for(Answer answer: entry.getValue()){
				result.append(answer);
			}
		}
		return result.toString();
	}

}
