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
	
	public void shuffle(){
		Collections.shuffle(questions);
	}
	
	public List<String> getQuestionsAndCorrectAnswers(){
		List <String> questionsAndCorrectAnswers = new ArrayList<String>();
		for(Question question: questions){
			questionsAndCorrectAnswers.add(new String(question.getText()));
			for(Answer answer: question.getAnswers()){
				if(answer.isCorrect){
					questionsAndCorrectAnswers.add(answer.getText());
				}
			}
		}
		return questionsAndCorrectAnswers;
	}
	
	public List<String> getQuestionsAndAllAnswers(){
		List <String> questionsAndAllAnswers = new ArrayList<String>();
		for(Question question: questions){
			questionsAndAllAnswers.add(question.getText() + "\n");
			for(Answer answer: question.getAnswers()){
				questionsAndAllAnswers.add(answer.getText());
			}
		}
		return questionsAndAllAnswers;
	}	

	public List<String> printIncorrectAnswers(){
		List <String> questionsAndAllAnswers = new ArrayList<String>();
		for(Question question: questions){
			questionsAndAllAnswers.addAll(question.printIncorrectAnswers());
		}
		return questionsAndAllAnswers;
	}

	public List<Integer> parseIds(String[] answers){
		List<Integer> ids = new ArrayList<Integer>();
		for(String answerId: answers){
			int id = Integer.parseInt(answerId);
			ids.add(new Integer(id));
		}
		return ids;
	}
	
	public int countCorrectAnswers(List<Integer> answerIds) {
		int correctAnswers = 0;
		for(Integer answerId: answerIds){
			if(isAnswerCorrect(answerId))correctAnswers++;
		}
		return correctAnswers;
	}
	
	public boolean isAnswerCorrect(int id){
		for(Question question: questions){
			for(Answer answer: question.getAnswers()){
				if(answer.isCorrect){
					if(answer.getId() == id){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	

	
	
}
