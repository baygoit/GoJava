package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	public Menu(){
		menuList.add("\n" + "1. Показать список вопросов и ответов");
		menuList.add("2. Начать собеседование");
		menuList.add("0. Выход");
	}
	
	static ArrayList <String> menuList = new ArrayList<String>();
	
	public static void printMenu(){
		for(String s : menuList){
			System.out.println(s);
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
			case 2: Interview.startInterview();break;
			case 0: System.exit(0);
			default: System.out.println("Вы ввели несуществующий пункт");
			System.exit(0);
		}
	}
}
