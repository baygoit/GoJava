package ua.com.goit.gojava.m__jane;

import java.util.Scanner;

import ua.com.goit.gojava.m__jane.model.Question;
import ua.com.goit.gojava.m__jane.service.QuestionService;
import ua.com.goit.gojava.m__jane.service.impl.QuestionServiceImpl;

public class MainClass {

	private static QuestionService questionService = new QuestionServiceImpl();
	
	public static void main(String[] args) {

		System.out.println("User story 1 - press 1 | User story 2 - press 2");
		Scanner scanIn = new Scanner(System.in);
		int choice = Integer.parseInt(scanIn.nextLine());

		if (choice == 1) {
			printAllQuestions();
		} else if (choice == 2) {
			askAndPrintOneQuestions(scanIn);
		} else {
			System.out.println("Wrong choice");
		}

	}


	private static void printAllQuestions() {
		for (Question question : questionService.getAllQuestions()) {
			System.out.println(question);
		}				
	}

	private static void askAndPrintOneQuestions(Scanner scanIn) {
				
		System.out.println("Enter number the question from 1 to " + questionService.getCount());
		Question question= questionService.getQuestionByNumber(scanIn.nextLine().trim());
		if (question == null) {
			System.out.println("Not found such question");
		} else {
			System.out.println(question);
		}
		
	}
}
