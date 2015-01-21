package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.List;

public class Question {
	
	private String question;
	private List <Answer> answers = new ArrayList <Answer>();
	
	public Question(){
		question = "there is a question must be here...";
	}
	
	public Question(String question, List <Answer> answers){
		this.question = question;
		for(Answer answer: answers){
			this.answers.add(answer);
		}
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public String toString(){
		return this.question + "\n" + answers + "\n";
	}
	
	public void printAllAnswers(){
		for(Answer answer: answers){
			System.out.println(answer.getAnswer());
		}
	}
	
	public void printCorrectAnswers(){
		for(Answer answer: answers){
			if(answer.isCorrect)System.out.println(answer.getAnswer() + "\n");
		}
	}
	
	public void printAswers(Question question){
		for(Answer answer: answers){
			answer.printNumberAndAnswer();
		}
	}
	
	public int searchNumberOfCorrectAnswer(){
	int numOfRightAnswer = 0;
		for(Answer answer: answers){
			if(answer.isCorrect){
				numOfRightAnswer = answer.getNumberOfAnswer();
				break;
			}
		}
		return numOfRightAnswer;
	}
	
	public boolean isCorrect(Question question, int answer){
		int numberOfRightAnswer = searchNumberOfCorrectAnswer();	
		if(answer == numberOfRightAnswer){
				return true;
			}
			else return false;
		}
		
	public int readAnswer(Menu menu){
		int choise = 0;
		while(choise < 1 || choise > 4){
			choise = menu.readInt();
		}
		return choise;
	}
}
