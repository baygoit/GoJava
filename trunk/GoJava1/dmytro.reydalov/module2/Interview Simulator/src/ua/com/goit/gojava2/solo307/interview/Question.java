package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.List;

public class Question {
	
	private String question;
	List <Answer> answers = new ArrayList <Answer>();
	
	public Question(){
		question = "there is a question must be here...";
	}
	
	public Question(String question, List <Answer> answers){
		this.question = question;
		for(Answer answer: answers){
			this.answers.add(answer);
		}
	}
	
	public String toString(){
		return this.question + "\n" + answers + "\n";
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public void printAllAnswers(){
		for(Answer answer: answers){
			System.out.println(answer.getAnswer());
		}
	}
	
	public void printRightAnswers(){
		for(Answer answer: answers){
			if(answer.isRight)System.out.println(answer.getAnswer() + "\n");
		}
	}
	
	public int searchNumberOfRightAnswer(){
	int numOfRightAnswer = 0;
		for(Answer answer: answers){
			if(answer.isRight){
				numOfRightAnswer = answer.getNumberOfAnswer();
				break;
			}
		}
		return numOfRightAnswer;
	}
	
	public void printAswers(Question question){
		for(Answer answer: answers){
			answer.printNumberAndAnswer();
		}
	}
	
	public boolean isRight(){
		int choose = 0;
		boolean isRight = false;
		while(choose < 1 || choose > 4){
			int numberOfRightAnswer = searchNumberOfRightAnswer();
			choose = Menu.ReadInt();
			if(choose == numberOfRightAnswer){
				isRight = true;
			}
		}
		return isRight;
	}
}































