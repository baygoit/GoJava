package ua.com.goit.gojava.m__jane.service;

import ua.com.goit.gojava.m__jane.model.Quiz;
import ua.com.goit.gojava.m__jane.model.User;
import ua.com.goit.gojava.m__jane.model.UserQuiz;



public interface UserQuizService {

	public UserQuiz createUserQuiz(User user, Quiz quiz);
}
