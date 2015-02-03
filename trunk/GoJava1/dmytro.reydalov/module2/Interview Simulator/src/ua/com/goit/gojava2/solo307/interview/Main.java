package ua.com.goit.gojava2.solo307.interview;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		Interview interview = new Interview();
		Menu menu = new Menu();
		int option = 0;
		while(option != menu.EXIT){
			menu.printMenu();
			option = menu.readInt();
			switch (option){
			case 1: interview.printQuestionsAndCorrectAnswers();break; 
			case 2: 
				List <Question> questions = interview.shuffle(interview.getQuestions());
				for(Question question: questions){
					final int CORRECT_ANSWERS = question.countCorrectAnswers();
					interview.printQuestionAndAllAnswers(question);
					List <Character> answeredIds = question.readAnswer();
					List <Answer> choosenAnswers = question.extractAnswers(answeredIds);
					List <Answer> correctAnswers = question.findCorrectAnswers(choosenAnswers);
					List <Answer> answeredWrong = question.findWrongAnswers(choosenAnswers);	
					int answeredCorrect = correctAnswers.size();
					if(answeredCorrect == CORRECT_ANSWERS)interview.addCorrectAnswers();
					else if(answeredCorrect > 0 && answeredCorrect < CORRECT_ANSWERS){
						interview.addPartiallyCorrectAnswers();
						question.addWrongAnswers(answeredWrong);
					}
					else {
						interview.addIncorrectAnswers();
						question.addWrongAnswers(answeredWrong);
					}
				}
				interview.printResults();
				interview.printIncorrectAnswers();
				break;
			}
		}
	}
}