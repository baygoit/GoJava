package ua.com.goit.gojava.m__jane.model;

import java.util.Date;
import java.util.List;

import ua.com.goit.gojava.m__jane.model.question.Question;
import ua.com.goit.gojava.m__jane.model.userAnswer.StatusUserAnswer;
import ua.com.goit.gojava.m__jane.model.userAnswer.UserAnswer;
import ua.com.goit.gojava.m__jane.service.QuestionService;

public class UserQuiz {

	//private Integer openQuestionResult;
	//private Integer closedQuestionResult;
		
	private Date testingDate;
	private List<UserAnswer> answerList;
	private QuestionService questionService;
	
		
	public void loadAnswers(List<QuestionCategory> categories) {
		
		for (Question question: questionService.getQuestionList(categories)) {
			UserAnswer userAnswer = question.createTemplateAnswer();
			userAnswer.setStatusUserAnswer(StatusUserAnswer.NEW);
			answerList.add(userAnswer);
		}
		
	}
	
	/*-------setters/getters---------*/
	
	public Date getTestingDate() {
		return testingDate;
	}
	public void setTestingDate(Date testingDate) {
		this.testingDate = testingDate;
	}
	public List<UserAnswer> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<UserAnswer> answerList) {
		this.answerList = answerList;
	}
		
}
