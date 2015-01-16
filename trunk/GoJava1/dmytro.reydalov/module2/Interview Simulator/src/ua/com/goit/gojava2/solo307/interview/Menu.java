package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	static ArrayList <String> options = new ArrayList<String>();
	
	public Menu(){
		options.add("\n" + "1. Показать список вопросов и ответов");
		options.add("2. Начать собеседование");
		options.add("0. Выход");
	}
	
	public static void printMenu(){
		for(String option : options){
			System.out.println(option);
		}
	}
	 
	public static int ReadInt(){
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
	
	public static void chooseOperation(int choise){
		switch (choise){
			case 1: Interview.showQuestionsAndAnswers();break; 
			case 2: int rightAnswers = Interview.countRightAnswers();
				Interview.isPassed(rightAnswers);
				break;
			case 0: System.exit(0);
			default: System.out.println("Вы ввели несуществующий пункт");
		}
	}
}
