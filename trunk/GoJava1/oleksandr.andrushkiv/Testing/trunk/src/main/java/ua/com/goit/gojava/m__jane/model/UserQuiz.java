package ua.com.goit.gojava.m__jane.model;

import java.util.Date;
import java.util.List;
import ua.com.goit.gojava.m__jane.model.answer.Answer;


public class UserQuiz {

	//private Integer openQuestionResult;
	//private Integer closedQuestionResult;
		
	private Date date;
	private List<Answer> answerList;
	//private QuestionService questionService;
	
	private User user;
	
	
	/*
	 * move to questionService UserQuizServiceImpl
	public void loadAnswers(List<Category> categories) {
		
		for (Question question: questionService.getQuestionList(categories)) {
			Answer answer = question.createTemplateAnswer();
			answer.setStatusUserAnswer(StatusAnswer.NEW);
			answerList.add(answer);
		}
		
	}
	*/
	
	/*-------setters/getters---------*/
	
	
	public List<Answer> getAnswerList() {
		return answerList;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
		
		
}
