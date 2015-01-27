package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question {
	
	private int id;
	private String text;
	private List <Answer> answers = new ArrayList <Answer>();
	
	public Question(){
		text = "there is a question must be here...";
	}
	
	public Question(String question, List <Answer> answers, int id){
		this.text = question;
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
		
	public int readAnswer(){
		int choise = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("\n" + "Пожалуйста, выберите пункт.");
		if(sc.hasNextInt()){
			return new Integer(sc.nextInt());
		}
		else{
			System.out.println("Вы ввели не число, Введите еще раз");
		}
		return choise;
	}
}
