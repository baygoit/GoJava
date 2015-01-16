package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.List;

public class Interview {
	public Interview(){
	}
	
	static List <Question> questions = new ArrayList <Question>();
	
	public void fillQuestionList(){
		List <Answer> answers = new ArrayList<Answer>();
		answers.add(new Answer("Процедурность, инкапсуляция, полиморфизм.", false, 1));
		answers.add(new Answer("Инкапсуляция, полиморфизм, наследование.", true, 2));
		answers.add(new Answer("Обьектность, ориентированность, программированность.", false, 3));
		answers.add(new Answer("Яйка, млако , колбаса.", false, 4));
		questions.add(new Question("Какие 3 принципа Обьектно - ориентированного программирования?", answers));
		answers.removeAll(answers);
		answers.add(new Answer("Использование специальных капсул для программистов, чтоб лучше думать.", false, 1));
		answers.add(new Answer("Возможность в программе избежать дублирования кода в программе.", false, 2));
		answers.add(new Answer("Механизм, используюемый для зашиты полей обьекта от попытки их изменения извне.", true, 3));
		answers.add(new Answer("Процесс создания графической оболочки.", false, 4));
		questions.add(new Question("Что такое инкапсуляция?", answers));
		answers.removeAll(answers);
		answers.add(new Answer("Возможность импортировать код с других языков программирования.", false, 1));
		answers.add(new Answer("Технология следования различным указателям.", false, 2));
		answers.add(new Answer("Инструмент для создания программных интерфейсов.", false, 3));
		answers.add(new Answer("Способность классом расширить уже существующий класс.", true, 4));
		questions.add(new Question("Что такое наследование", answers));
		answers.removeAll(answers);
		answers.add(new Answer("Способность обращаться ко всем подклассам расширенного класса одинаково, "
								+ "\n" + "но при этом каждый будет вести себя по своему.", true, 1));
		answers.add(new Answer("Элемент полимонального морфизма.", false, 2));
		answers.add(new Answer("Инструмент для оформления различных строк.", false, 3));
		answers.add(new Answer("Шаблон проэктрования.", false, 4));
		questions.add(new Question("Что такое полиморфизм?", answers));
	}
	
	public static void showQuestionsAndAnswers(){
		for(Question question: questions){
			System.out.println(question.getQuestion());
			question.printRightAnswers();
		}
	}
	
	public static int countRightAnswers(){
		int successAnswers = 0;
		for(Question question: questions){
			System.out.println(question.getQuestion() + "\n");
			question.printAswers(question);
			if(question.isRight())successAnswers++;
		}
		return successAnswers;
	}
		
	public static boolean isPassed(int successAnswers){
		if(successAnswers > (questions.size() / 2)){
			System.out.println("Вы приняты на работу!!!" + "\n" + "Правильных ответов: " + successAnswers + "\n");
			System.exit(0);
		}
		else System.out.println("Кгм, мы вам перезвоним..." + "\n" + "Правильных ответов: " + successAnswers + "\n"
				 				+ "Почитайте раздел Список вопросов и ответов, и возвращайтесь:-)");
		return false;
	}
}
