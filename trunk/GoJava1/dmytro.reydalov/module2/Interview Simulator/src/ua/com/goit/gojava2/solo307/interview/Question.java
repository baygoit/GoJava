package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.List;

public class Question {
	
	public Question(){
		question = "question";
	}
	
	public Question(String question, Answer wrightAnswer, Answer wrongAnswer){
		this.question = question;
		answersList.add(wrightAnswer);
		answersList.add(wrongAnswer);
		menu = new Menu();
	}
	
	private String question;
	List <Answer> answersList = new ArrayList <Answer>();
	Menu menu;
	
	public String toString(){
		return this.question + "\n" + answersList + "\n";
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public void printAllAnswers(){
		for(Answer answs: answersList){
			System.out.println(answs.getAnswer());
		}
	}
	
	public void printRightAnswers(){
		for(Answer answs: answersList){
			if(answs.isAnswerRight)System.out.println(answs.getAnswer());
		}
	}
	
	public Answer getRightAnswer(Question question){
		Answer rightAnswer = new Answer();
		for(Answer answs: answersList){
			if(answs.isAnswerRight)rightAnswer = answs;
		}
		return rightAnswer;
	}
	
	public Answer getWrongAnswer(Question question){
		Answer wrongAnswer = new Answer();
		for(Answer answs: answersList){
			if(!answs.isAnswerRight)wrongAnswer = answs;
		}
		return wrongAnswer;
	}
	
	public Answer readUserAnswer(Question question){
		Answer rightAnswer = getRightAnswer(question);
		Answer wrongAnswer = getWrongAnswer(question);
		System.out.println("1. " + rightAnswer.getAnswer());
		System.out.println("2. " + wrongAnswer.getAnswer());
		int choose = menu.ReadInt();
		if(choose == 1) return rightAnswer;
		else if(choose == 2)return wrongAnswer;
		else {
			System.out.println("Такого пункта не существует");
			readUserAnswer(question);
		}
		return new Answer();
	}
}
































