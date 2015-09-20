package model;

import java.util.ArrayList;

public class QuestionsAndAnswersRepository {
	
	private ArrayList<String> questionsAndAnswers;
	
	public QuestionsAndAnswersRepository() {
		questionsAndAnswers = new ArrayList<>();
		
		questionsAndAnswers.add("Question 1; -> Answer 1;");
		questionsAndAnswers.add("Question 2; -> Answer 2;");
		questionsAndAnswers.add("Question 3; -> Answer 3;");
	}
	
	public ArrayList<String> getQuestionsAndAnswers(){
		return questionsAndAnswers;
	}

}
