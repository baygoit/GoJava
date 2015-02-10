package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Category {
	
	private String name;
	private List <Question> questions = new ArrayList<Question>();

	public Category(){
		this.name = "Current Category";
	}
	
	public Category(String path, String name) {
		this.name = name;
		questions = readData(path);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public List<Question> readData(String path) {
		XMLParser parser = null;
		try {
			parser = new XMLParser(path);
		} catch (InterviewSimulatorException e) {
			e.getMessage();
		}
		return parser.questions;
	}
	
	public List<Question> shuffle(List <Question> questions){
		Collections.shuffle(questions);
		return questions;
	}
	
	public void printQuestionsAndCorrectAnswers(){
		for(Question question: questions){
			System.out.println("\n" + question.getId() +". " + question.getText());
			question.printCorrectAnswers();
		}
	}
	
	public void printQuestionAndAllAnswers(){
		for(Question question: questions){
			System.out.println(question.getId() +". " + question.getText() + "\n");
			question.printAswers();
		}
	}	
	
	public void printQuestionAndAllAnswers(Question question){
		System.out.println(question.getId() +". " + question.getText() + "\n");
		question.printAswers();
	}

	public void printIncorrectAnswers(){
		System.out.println("\nНеправильные ответы: ");
		for(Question question: questions){
			question.printIncorrectAnswers(question);
		}
	}

	public void addQuestions(List<Question> questions) {
		for(Question question: questions){
			this.questions.add(new Question(question.getText(), question.getAnswers(), question.getId()));
		}
	}
	
}
