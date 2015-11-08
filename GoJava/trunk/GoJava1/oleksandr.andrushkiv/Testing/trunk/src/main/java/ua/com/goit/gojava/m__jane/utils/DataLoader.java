package ua.com.goit.gojava.m__jane.utils;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import ua.com.goit.gojava.m__jane.model.Category;
import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.model.Quiz;
import ua.com.goit.gojava.m__jane.model.User;
import ua.com.goit.gojava.m__jane.model.question.MultipleQuestion;
import ua.com.goit.gojava.m__jane.model.question.Question;
import ua.com.goit.gojava.m__jane.model.question.SimpleQuestion;

@XmlRootElement(name="rootElement")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataLoader {
	
	@XmlElements({
		@XmlElement(name = "questionMu", type=MultipleQuestion.class), 
		@XmlElement(name = "questionSi", type=SimpleQuestion.class)
		})	
	@XmlElementWrapper(name = "questions")
	private List<Question> questionList;
	
	@XmlElement(name = "questionCategory")
	@XmlElementWrapper(name = "questionCategories")
	private  List<Category> categoryList;
	
	@XmlElement(name = "quiz")
	@XmlElementWrapper(name = "quizzes")
	private  List<Quiz> quizList;
	
	@XmlElement(name = "profile")
	@XmlElementWrapper(name = "profiles")
	private List<Profile> profileList;
	
	@XmlElement(name = "user")
	@XmlElementWrapper(name = "users")
	private List<User> userList;
	

	public List<Profile> getProfileList() {
		if (profileList == null) {
			profileList = new ArrayList<Profile>();
		}
		return profileList;
	}


	public List<User> getUserList() {
		if (userList == null) {
			userList = new ArrayList<User>();
		}
		return userList;
	}


	public List<Question> getQuestionList() {
		if (questionList == null) {
			questionList = new ArrayList<Question>();
		}
		return questionList;
	}

	public List<Category> getCategoryList() {
		if (categoryList == null) {
			categoryList = new ArrayList<Category>();
		}
		return categoryList;
	}
	

}
