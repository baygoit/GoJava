package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question {
	
	private int id;
	private String text;
	private List <Answer> answers = new ArrayList <Answer>();
	
	public Question(){
		this.text = "there is a question must be here...";
	}
	
	public Question(String text, List <Answer> answers, int id){
		this.text = text;
		for(Answer answer: answers){
			this.answers.add(answer);
		}
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}
	
	public void setText(String question) {
		this.text = question;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public void printCorrectAnswers(){
		for(Answer answer: answers){
			if(answer.isCorrect)System.out.println(answer.getText() + "\n");
		}
	}
	
	public void printAswers(Question question){
		for(Answer answer: answers){
			answer.printIdAndAnswer();
		}
	}
	
	public int searchNumberOfCorrectAnswer(){
	int numOfRightAnswer = 0;
		for(Answer answer: answers){
			if(answer.isCorrect){
				numOfRightAnswer = answer.getId();
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
		
	public int readAnswer(){
		int option = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("\n" + "Пожалуйста, выберите пункт.");
		if(sc.hasNextInt()){
			return new Integer(sc.nextInt());
		}
		else{
			System.out.println("Вы ввели не число, Введите еще раз");
		}
		return option;
	}
	
	public boolean isAnswerIdExists(int id){
		for(Answer answer: answers){
			if(id == answer.getId()){
				return true;
			}
		}
		return false;
	}
}
