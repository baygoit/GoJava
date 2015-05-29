package com.ivanpozharskyi.kickstarter.datastorage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ivanpozharskyi.kickstarter.main.Kickstarter;

public class QuestionStorage {
	private ReaderFromFile readerFromFile;

	private Map<Question, ArrayList<Answer>> questionAndAnswers = new HashMap<Question, ArrayList<Answer>>();

	private Kickstarter kickstarter;
	

	public QuestionStorage() {
		
	}
//	public void addQuestionsAndAnswersFromFile(String fileName) throws IOException{
//		readerFromFile = new ReaderFromFile(fileName);
//		List<String> namesParametres = readerFromFile.read();
//		for(String nameParametres:namesParametres ){
//			
//			questionAndAnswers.put(key, value);
//		}
//		
//		
//	}
	public QuestionStorage(Question question, ArrayList<Answer> answer) {
		questionAndAnswers.put(question, answer);
	}

	public QuestionStorage(Kickstarter kickstarter) {
		this.kickstarter = kickstarter;
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
