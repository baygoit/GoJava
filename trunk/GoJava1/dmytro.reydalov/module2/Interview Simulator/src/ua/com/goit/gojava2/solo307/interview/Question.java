package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Question {
	
	private int id;
	private String text;
	private List <Answer> answers = new ArrayList <Answer>();
	private List <Answer> incorrectAnswers = new ArrayList <Answer>();
		
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

	public List<Answer> getIncorrectAnswers() {
		return incorrectAnswers;
	}

	public void setIncorrectAnswers(List<Answer> wrongAnswers) {
		this.incorrectAnswers = wrongAnswers;
	}

	public void printCorrectAnswers(){
		for(Answer answer: answers){
			if(answer.isCorrect)System.out.println("\n" + answer.getText());
		}
	}
	
	public void printAswers(Question question){
		for(Answer answer: answers){
			answer.printIdAndAnswer();
		}
	}
	
	public int countCorrectAnswers(){
		int counter = 0;
		for(Answer answer: answers){
			if(answer.isCorrect)counter++;
		}
		return counter;
	}
	
	public List <Character> readAnswer(){
		System.out.println("\n" + "Пожалуйста, выберите вариант, если их несколько, введите числа через пробел.");	
		String inLine = new String(new Scanner(System.in).nextLine());
		Set <Character> characters = new HashSet <Character>();
		for(int i = 0; i < inLine.length(); i++){
			if(isIdExists(inLine.charAt(i))) characters.add(inLine.charAt(i));
		}
		List <Character> answers = new ArrayList<Character>(characters);
		return answers;
	}
			
	public boolean isIdExists(char variant){
		for(int i = 0; i < answers.size(); i++){
			if(variant == answers.get(i).getId()) return true;
		}
		return false;
	}
	
	public List <Answer> extractAnswers(List <Character> answeredIds){
		List <Answer> choosenAnswers = new ArrayList<Answer>();
		for(int i = 0; i < answeredIds.size(); i++){
			for(int j = 0; j < answers.size(); j++){
				if(answeredIds.get(i) == answers.get(j).getId()){
					choosenAnswers.add(answers.get(j));
				}
			}
		}
		return choosenAnswers;
	}
	
	public void addWrongAnswers(List <Answer> answeredWrong){
		for(Answer answer: answeredWrong){
			incorrectAnswers.add(answer);
		}
	}

	public void printWrongAnswers(Question question) {
		for(Answer answer: incorrectAnswers){
			System.out.println("\n" + question.getText());
			System.out.println(answer.getText());
		}
	}

	public List <Answer> findCorrectAnswers(List <Answer> choosenAnswers) {
		List <Answer> correctAnswers = new ArrayList<Answer>();
		for(int i = 0; i < choosenAnswers.size(); i++){
			if(choosenAnswers.get(i).isCorrect){
				correctAnswers.add(choosenAnswers.get(i));
			}
		}
		return correctAnswers;
	}
	
	public List <Answer> findWrongAnswers(List <Answer> choosenAnswers) {
		List <Answer> wrongAnswers = new ArrayList<Answer>();
		for(int i = 0; i < choosenAnswers.size(); i++){
			if(!choosenAnswers.get(i).isCorrect){
				wrongAnswers.add(choosenAnswers.get(i));
			}
		}
		return wrongAnswers;
	}
}
