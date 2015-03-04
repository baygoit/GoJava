package ua.com.goit.gojava.m__jane.service.implXML;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import ua.com.goit.gojava.m__jane.model.Category;
import ua.com.goit.gojava.m__jane.model.Quiz;
import ua.com.goit.gojava.m__jane.model.User;
import ua.com.goit.gojava.m__jane.model.UserQuiz;
import ua.com.goit.gojava.m__jane.model.answer.Answer;
import ua.com.goit.gojava.m__jane.model.question.Question;
import ua.com.goit.gojava.m__jane.service.UserQuizService;
import ua.com.goit.gojava.m__jane.service.implXML.UserQuizServiceImplXML;

public class UserQuizServiceXMLTest {

	private static UserQuizService userQuizService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userQuizService = new UserQuizServiceImplXML();
	}

	@Test
	public void testCreateUserQuiz() {
		
		List<Question> questionList1 = new ArrayList<>();
		addQuestions(questionList1, 3);
		List<Question> questionList2 = new ArrayList<>();
		addQuestions(questionList2, 2);		
		
		//--------
		Category categ1 = new Category();	
		categ1.setQuestionList(questionList1);
		
		Category categ2 = new Category();
		categ2.setQuestionList(questionList2);
		
		//--------
		List<Category> categoryList = new ArrayList<>();
		categoryList.add(categ1);
		categoryList.add(categ2);
		
		//--------
		Quiz quiz = new Quiz();
		quiz.setCategoryList(categoryList);
		
		
		UserQuiz userQuiz = userQuizService.createUserQuiz(new User(), quiz);
		assertNotNull(userQuiz);
		assertEquals(questionList1.size()+questionList2.size(), userQuiz.getAnswerList().size());
	}
	
	private void addQuestions(List<Question> questionList, int amount) {
		
		for (int i = 0; i <amount; i++) {
			questionList.add(new Question() {				
				@Override
				public Answer createTemplateAnswer() {
					// TODO Auto-generated method stub
					return new Answer() {
						
						@Override
						public void checkAnswer() {
							// TODO Auto-generated method stub						
						}
					};
				}
			});
		}		
	}

}
