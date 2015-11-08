package ua.com.goit.gojava.m__jane.service.implXML;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import ua.com.goit.gojava.m__jane.model.Category;
import ua.com.goit.gojava.m__jane.model.answer.Answer;
import ua.com.goit.gojava.m__jane.model.question.Question;
import ua.com.goit.gojava.m__jane.service.QuestionService;
import ua.com.goit.gojava.m__jane.service.implXML.QuestionServiceImplXML;

public class QuestionServiceXMLTest {

	private static QuestionService questionService;
	//private static DataLoader dataLoader;

	@BeforeClass
	public static void setUpBeforeClass() {
		questionService = new QuestionServiceImplXML();
		//dataLoader = DataBuilder.getInstance().getDataLoader();
	}

	@Test
	public void testGetQuestionList() {
		
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
		
		questionService.getQuestionList(categoryList);
		assertNotNull(questionService.getQuestionList(categoryList));
		assertEquals(5, questionService.getQuestionList(categoryList).size());
		
		//ReflectionAssert.assertReflectionEquals(question0, question);
	}
	
	private void addQuestions(List<Question> questionList, int amount) {
		
		for (int i = 0; i <amount; i++) {
			questionList.add(new Question() {				
				@Override
				public Answer createTemplateAnswer() {
					// TODO Auto-generated method stub
					return null;
				}
			});
		}		
	}

}
