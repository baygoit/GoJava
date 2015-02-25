package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Question {
	
	private int id;
	private String text;
	private List <Answer> answers = new ArrayList <Answer>();
	private Mark mark;
		
	public Question(){
		this.text = "there is a question must be here...";
	}
	
	public Question(String text, List <Answer> answers, int id){
		this.text = text;
		this.answers = answers;
		this.id = id;
		this.mark = new Mark();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}
	
	public void setText(String question) {
		this.text = question;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}

	public boolean hasNextId(int answeredId) {
		for(Answer answer: answers){
			if(answer.hasNextId(answeredId)){
				return true;
			}
		}
		return false;
	}

	public Mark getCurrentMark(Set<Integer> answerIds) {
		final int ZERO = 0;
		int counter = ZERO;
		for(Answer answer: answers){
			for(Integer id: answerIds){
				if(answer.hasNextId(id) && answer.isCorrect)counter++;
			}
		}
		final int correctAnswers = countCorrectAnswers();
		if(counter > ZERO && counter < correctAnswers || counter > correctAnswers)mark.setHalfcorrect(true);
		else if(counter == ZERO)mark.setIncorrect(true);
		else if(counter == correctAnswers)mark.setCorrect(true);
		mark.setQuestionText(getText());
		List<Answer> answers= getAnswers(answerIds);
		mark.setAnswers(answers);
		return mark;
	}

	private List<Answer> getAnswers(Set<Integer> answerIds) {
		List <Answer> answers = new ArrayList <Answer>();
		for(Answer answer: this.answers){
			for(Integer id: answerIds){
				if(answer.hasNextId(id)) answers.add(answer);
			}
		}
		return answers;
	}

	private int countCorrectAnswers() {
		int counter = 0;
		for(Answer answer: answers){
			if(answer.isCorrect)counter++;
		}
		return counter;
	}	
}
