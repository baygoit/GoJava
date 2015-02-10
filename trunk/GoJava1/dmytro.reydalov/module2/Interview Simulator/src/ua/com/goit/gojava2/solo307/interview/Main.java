package ua.com.goit.gojava2.solo307.interview;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		Interview interview = new Interview();
		final String NAME = "Questions";
		final String PATH = "Questions.xml";
		interview.addCategory(PATH, NAME);
		final String NAME2 = "Questions1";
		final String PATH2 = "MeratechTest.xml";
		interview.addCategory(PATH2, NAME2);
		interview.composeCategory(interview.getCategories());
		Menu menu = new Menu();
		int option = 0;
		while(option != menu.EXIT){
			menu.printMenu();
			option = menu.readInt();
			switch (option){
			case 1: interview.getCurrentCategory().printQuestionsAndCorrectAnswers();break; 
			case 2: interview.getCurrentCategory().printQuestionAndAllAnswers(); break;
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
				try {
					String time = interview.timecounter.formatIntoMMSS(seconds);
					System.out.println("Время " + time);
				} catch (InterviewSimulatorException e) {
					e.getMessage();
				}
				interview.printResults();
				interview.getCurrentCategory().printIncorrectAnswers();
				break;
			}
		}
	}
}