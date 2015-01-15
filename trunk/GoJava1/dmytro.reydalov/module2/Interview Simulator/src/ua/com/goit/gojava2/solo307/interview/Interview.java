package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.List;

public class Interview {
	public Interview(){
		
	}
	
	static List <Question> questionList = new ArrayList <Question>();
	
	public void fillQuestionList(){
		questionList.add(new Question("Какие 3 принципа ООП?", new Answer("Инкапсуляция, полиморфизм, наследование", true), 
						new Answer("Яйка, Млако , Колбаса", false)));
		Menu.printMenu();
		Menu.chooseOperation(Menu.ReadInt());
	}
	
	public static void showQuestionsAndAnswers(){
		System.out.println(questionList.get(0).getQuestion());
		questionList.get(0).printRightAnswers();
	}
	
	public static int startInterview(){
		int successAnswers = 0;
		System.out.println(questionList.get(0).getQuestion() + "\n");
		Answer answer = questionList.get(0).readUserAnswer(questionList.get(0));
		if(answer.isAnswerRight)successAnswers++;
		if(successAnswers > 0)System.out.println("Вы приняты на работу!!!");
		else System.out.println("Кгм, мы вам перезвоним...");
		return successAnswers;
	}
}
