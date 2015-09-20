package ua.com.goit.gojava.m__jane.service.implXML;

import java.util.ArrayList;
import java.util.List;
import ua.com.goit.gojava.m__jane.model.Quiz;
import ua.com.goit.gojava.m__jane.model.User;
import ua.com.goit.gojava.m__jane.model.UserQuiz;
import ua.com.goit.gojava.m__jane.model.answer.Answer;
import ua.com.goit.gojava.m__jane.model.answer.AnswerStatus;
import ua.com.goit.gojava.m__jane.model.question.Question;
import ua.com.goit.gojava.m__jane.service.QuestionService;
import ua.com.goit.gojava.m__jane.service.UserQuizService;

public class UserQuizServiceImplXML implements UserQuizService {

	private QuestionService questionService;	
	//while hasn't DB
	//private ProfileService profileService;

	
	public UserQuizServiceImplXML() {

		this.questionService = new QuestionServiceImplXML();
		//this.profileService = new ProfileServiceImpl();
	}

	
	@Override
	public UserQuiz createUserQuiz(User user, Quiz quiz) {
		
		UserQuiz userQuiz = new UserQuiz();
		List<Answer> answerList = new ArrayList<>();		
		for (Question question : questionService.getQuestionList(quiz.getCategoryList())) {
			Answer answer = question.createTemplateAnswer();
			answer.setStatusUserAnswer(AnswerStatus.NEW);
			answerList.add(answer);
		}
		
		userQuiz.setAnswerList(answerList);
		userQuiz.setUser(user);
		return userQuiz;
	}


}
