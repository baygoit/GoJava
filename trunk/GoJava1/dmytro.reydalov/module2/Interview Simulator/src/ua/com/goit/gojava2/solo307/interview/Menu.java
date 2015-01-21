package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	private ArrayList <String> options = new ArrayList<String>();
	
	public Menu(){
		options.add("\n" + "1. Показать список вопросов и ответов");
		options.add("2. Начать собеседование");
		options.add("0. Выход");
	}
	
	public ArrayList<String> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}

	public void printMenu(){
		for(String option : options){
			System.out.println(option);
		}
	}
	 
	public int readInt(){
		Scanner sc = new Scanner(System.in);
		System.out.println("\n" + "Пожалуйста, выберите пункт.");
		if(sc.hasNextInt()){
			return new Integer(sc.nextInt());
		}
		else{
			System.out.println("Вы ввели не число, запустите программу еще раз...");
			return 0;
		}
	}
	
	public void chooseOperation(int choise, Interview interview){
		switch (choise){
			case 1: interview.printQuestionsAndCorrectAnswers();break; 
			case 2: 
				int correctAnswers = 0;
				for(Question question: interview.getQuestions()){
					interview.printQuestionAndAllAnswers(question);
					int answer = question.readAnswer(this);
					if(question.isCorrect(question, answer)) correctAnswers++;
				}
				interview.isPassed(correctAnswers);
				break;
			case 0: System.exit(0);
			default: System.out.println("Вы ввели несуществующий пункт");
		}
	}
}
