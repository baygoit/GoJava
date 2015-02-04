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
			case 2: interview.printQuestionAndAllAnswers(); break;
			case 3: 
				List <Question> questions = interview.shuffle(interview.getQuestions());
				for(Question question: questions){
					final int CORRECT_ANSWERS = question.countCorrectAnswers();
					interview.printQuestionAndAllAnswers(question);
					question.setAnsweredIds(question.readAnswer());
					question.setChoosenAnswers(question.extractAnswers(question.getAnsweredIds()));
					question.setCorrectAnswers(question.findCorrectAnswers(question.getChoosenAnswers()));
					question.setAnsweredWrong(question.findWrongAnswers(question.getChoosenAnswers()));	
					int answeredCorrect = question.getCorrectAnswers().size();
					if(answeredCorrect == CORRECT_ANSWERS)interview.addCorrectAnswers();
					else if(answeredCorrect > 0 && answeredCorrect < CORRECT_ANSWERS){
						interview.addPartiallyCorrectAnswers();
						question.addWrongAnswers(question.getAnsweredWrong());
					}
					else {
						interview.addIncorrectAnswers();
						question.addWrongAnswers(question.getAnsweredWrong());
					}
				}
				interview.printResults();
				interview.printIncorrectAnswers();
				break;
			}
		}
	}
}