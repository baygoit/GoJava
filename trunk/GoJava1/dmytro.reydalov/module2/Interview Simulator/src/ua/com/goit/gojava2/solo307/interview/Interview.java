package ua.com.goit.gojava2.solo307.interview;

import java.util.List;

public class Interview {
	
	private List <Question> questions = readFromXml();
	
	public Interview(){
		
	}
	
	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Question> readFromXml(){
		XMLParser parser = new XMLParser();
		parser.parse();
		return parser.questions;
	}
	
	public void printQuestionsAndCorrectAnswers(){
		for(Question question: questions){
			System.out.println(question.getText());
			question.printCorrectAnswers();
		}
	}
	
	public void printQuestionAndAllAnswers(Question question){
			System.out.println(question.getText() + "\n");
			question.printAswers(question);
	}
			
	public boolean isPassed(int successAnswers){
		if(successAnswers > (questions.size() / 2)){
			System.out.println("Вы приняты на работу!!!" + "\n" + "Правильных ответов: " + successAnswers + "\n");
			return true;
		}
		else System.out.println("Кгм, мы вам перезвоним..." + "\n" + "Правильных ответов: " + successAnswers + "\n"
				 				+ "Почитайте раздел Список вопросов и ответов, и возвращайтесь:-)");
		return false;
	}
}
