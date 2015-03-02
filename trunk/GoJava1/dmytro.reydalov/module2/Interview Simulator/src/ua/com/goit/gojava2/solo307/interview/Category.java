package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Category {
	
	private String name;
	private List <Question> questions = new ArrayList<Question>();
	
	public Category(String name, List<Question> questions){
		this.name = name;
		this.questions = questions;
	}
	
	public Category(String name){
		this.name = name;
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
	
	public List<String> getQuestionsAndCorrectAnswers(){
		List <String> questionsAndCorrectAnswers = new ArrayList<String>();
		for(Question question: questions){
			questionsAndCorrectAnswers.add(new String(question.getId() + ". " + question.getText()));
			for(Answer answer: question.getAnswers()){
				if(answer.isCorrect){
					questionsAndCorrectAnswers.add(answer.getId() + ". " + answer.getText());
				}
			}
		}
		return questionsAndCorrectAnswers;
	}
	
	public List<String> getQuestionsAndAllAnswers(){
		List <String> questionsAndAllAnswers = new ArrayList<String>();
		for(Question question: questions){
			questionsAndAllAnswers.add(question.getId() + ". " + question.getText() + "\n");
			for(Answer answer: question.getAnswers()){
				questionsAndAllAnswers.add(answer.getId() + ". " + answer.getText());
			}
		}
		return questionsAndAllAnswers;
	}	

	public Set<Integer> parseIds(String[] answers){
		Set<Integer> ids = new HashSet<Integer>();
		for(String answerId: answers){
			int id = Integer.parseInt(answerId);
			ids.add(new Integer(id));
		}
		return ids;
	}

	public Set<Question> getQuestionsById(Set<Integer> answerIds) {
		Set<Question> reconstructed = new HashSet<Question>();
		for(Question question: questions){
			for(Integer id: answerIds){
				if(question.hasNextId(id)){
					reconstructed.add(question);
				}
			}
		}
		return reconstructed;
	}

	public List<Mark> getMarks(Set<Question> reconstructed, Set<Integer> answerIds) {
		List <Mark> marks = new ArrayList<Mark>();
		for(Question question: reconstructed){
			marks.add(question.getCurrentMark(answerIds));
		}
		return marks;
	}
	
	public List<String> getStatistics(){
		List<String> statistics = new ArrayList<String>();
		int correct = 0;
		int halfCorrect = 0;
		int incorrect = 0;
		for(Question question: questions){
			if(question.getMark().isCorrect())correct++;
			else if(question.getMark().isHalfcorrect())halfCorrect++;
			else if(question.getMark().isIncorrect())incorrect++;
		}
		statistics.add(new String("Правильных ответов: " + correct));
		statistics.add(new String("Частично правильных ответов: " + halfCorrect));
		statistics.add(new String("Неправильных ответов: " + incorrect)); 
		return statistics;
	}
}
