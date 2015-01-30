package ua.com.goit.gojava2.solo307.interview;

import java.util.Collections;
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
				int correctAnswers = 0;
				List <Question> randomQuestions = interview.getQuestions();
				Collections.shuffle(randomQuestions);
				for(Question question: randomQuestions){
					interview.printQuestionAndAllAnswers(question);
					int answerNumber = 0;
					while(!question.isAnswerIdExists(answerNumber)){
						answerNumber = menu.readInt();
					}
					if(question.isCorrect(question, answerNumber)) correctAnswers++;
				}
				interview.isPassed(correctAnswers);
				break;
			}
		}
	}
}
