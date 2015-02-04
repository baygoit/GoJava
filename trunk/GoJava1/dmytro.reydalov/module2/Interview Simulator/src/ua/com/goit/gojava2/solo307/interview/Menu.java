package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	private ArrayList <String> options = new ArrayList<String>();
	final int EXIT = 9;
	final int SHOW_QUESTIONS = 1;
	final int START = 2;
	
	public Menu(){
		options.add("\n" + "1. Показать список вопросов и правильных ответов");
		options.add("2. Показать список вопросов и всех ответов");
		options.add("3. Начать тест");
		options.add("9. Выход");
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
		final int NULL = 0;
		System.out.println("\n" + "Пожалуйста, введите число.");
		try{
			return new Integer(new Scanner(System.in).nextInt());
		} catch(InputMismatchException e){
			return NULL;
		}
	}
}
