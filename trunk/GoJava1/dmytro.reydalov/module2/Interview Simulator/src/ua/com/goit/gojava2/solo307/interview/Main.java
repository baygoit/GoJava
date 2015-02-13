package ua.com.goit.gojava2.solo307.interview;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		System.out.println("Напишите ваше имя");
		String name = new String(new Scanner(System.in).nextLine());
		Interview interview = new Interview();
		File file = new File("Questions.xml.");
		interview.addCategory("Questions", file.getAbsolutePath());
		File file2 = new File("MeratechTest.xml.");
		interview.addCategory("Questions1", file2.getAbsolutePath());
		interview.composeCategory(interview.getCategories());
		Menu menu = new Menu();
		int option = 0;
		while(option != menu.EXIT){
			menu.printMenu();
			option = menu.readInt();
			switch (option){
			case 1: interview.getCurrentCategory().printQuestionsAndCorrectAnswers();break; 
			case 2: 
				List<String> questionsAndAllAnswers = interview.getCurrentCategory().getQuestionsAndAllAnswers();
				for(String string: questionsAndAllAnswers){
					System.out.println(string);
				} break;
			case 3: 
				interview.timecounter = new TimeCounter();
				List <Question> questions = interview.getCurrentCategory().shuffle(interview.getCurrentCategory().getQuestions());
				for(Question question: questions){
					final int CORRECT_ANSWERS = question.countCorrectAnswers();
					interview.getCurrentCategory().printQuestionAndAllAnswers(question);
					question.setAnsweredIds(question.readAnswer());
					question.setChoosenAnswers(question.extractAnswers(question.getAnsweredIds()));
					question.setCorrectAnswers(question.findCorrectAnswers(question.getChoosenAnswers()));
					question.setAnsweredWrong(question.findIncorrectAnswers(question.getChoosenAnswers()));	
					int answeredCorrect = question.getCorrectAnswers().size();
					if(answeredCorrect == CORRECT_ANSWERS)interview.addCorrectAnswers();
					else if(answeredCorrect > 0 && answeredCorrect < CORRECT_ANSWERS){
						interview.addPartiallyCorrectAnswers();
						question.addIncorrectAnswers(question.getAnsweredWrong());
					}
					else {
						interview.addIncorrectAnswers();
						question.addIncorrectAnswers(question.getAnsweredWrong());
					}
				}
				long seconds = interview.timecounter.calculateSeconds(interview.timecounter.elapsedTime());
				String time = "";
				try {
					time = interview.timecounter.formatIntoMMSS(seconds);
					System.out.println("Время " + time);
				} catch (InterviewSimulatorException e) {
					e.getMessage();
				}
				List<String> results = interview.getResults();
				interview.printList(results);
				List<String> incorrectAnswers = interview.getCurrentCategory().printIncorrectAnswers();
				System.out.println("\nНеправильные ответы: ");
				interview.printList(incorrectAnswers);
				interview.writeToFile(name, time, results, incorrectAnswers);
				break;
			}
		}
	}
}