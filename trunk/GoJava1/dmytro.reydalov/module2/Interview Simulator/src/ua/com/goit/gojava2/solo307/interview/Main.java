package ua.com.goit.gojava2.solo307.interview;

public class Main {
	public static void main(String[] args) {
		Interview interview = new Interview();
		Menu menu = new Menu();
		int choise = 1;
		while(choise != 0){
			menu.printMenu();
			choise = menu.readInt();
			switch (choise){
			case 1: interview.printQuestionsAndCorrectAnswers();break; 
			case 2: 
				int correctAnswers = 0;
				for(Question question: interview.getQuestions()){
					interview.printQuestionAndAllAnswers(question);
					int answerNumber = 0;
					while(answerNumber < 1 || answerNumber > 4){
						answerNumber = menu.readInt();
					}
					if(question.isCorrect(question, answerNumber)) correctAnswers++;
				}
				interview.isPassed(correctAnswers);
				break;
			case 0: System.exit(0);
			default: System.out.println("Вы ввели несуществующий пункт");
			}
		}
	}
}
