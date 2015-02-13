package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Category {
	
	private String name;
	private List <Question> questions = new ArrayList<Question>();

	public Category(){
		this.name = "There must be a Category name here...";
	}
	
	public Category(String name){
		this.name = name;
	}
	
	public Category(String name, String path) throws InterviewSimulatorException {
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
	
	public void addQuestions(List<Question> questions) {
		for(Question question: questions){
			this.questions.add(new Question(question.getText(), question.getAnswers(), question.getId()));
		}
	}
	
	public List<Question> readData(String path) throws InterviewSimulatorException {
		XMLParser parser = new XMLParser(path);
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
	
	public List<String> getQuestionsAndAllAnswers(){
		List <String> questionsAndAllAnswers = new ArrayList<String>();
		for(Question question: questions){
			questionsAndAllAnswers.add(question.getId() +". " + question.getText() + "\n");
			for(Answer answer: question.getAnswers()){
				questionsAndAllAnswers.add(answer.getIdAndAnswer());
			}
		}
		return questionsAndAllAnswers;
	}	
	
	public void printQuestionAndAllAnswers(Question question){
		System.out.println(question.getId() +". " + question.getText() + "\n");
		question.printAswers();
	}

	public List<String> printIncorrectAnswers(){
		List <String> questionsAndAllAnswers = new ArrayList<String>();
		for(Question question: questions){
			questionsAndAllAnswers.addAll(question.printIncorrectAnswers());
		}
		return questionsAndAllAnswers;
	}

	
	
}
