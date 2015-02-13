package ua.com.goit.gojava2.solo307.interview;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCategory {
	Category categoryDefault = new Category();
	Category categoryName = new Category();
	Category categoryNamePath = new Category();
	Category categoryNameWrongPath = new Category();
	
	@Before
	public void setUp() throws Exception {
		categoryDefault = new Category();
//		categoryName = new Category("My Category");
//		categoryNamePath = new Category("My Category", "Questions.xml");
//		categoryNameWrongPath = new Category("My Category", "Some File");
	}

	@Test
	public void testCategory() {
		String expected = "There must be a Category name here...";
		String actual = categoryDefault.getName();
		assertEquals(expected, actual);
	}

//	@Test
//	public void testCategoryString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCategoryStringString() {
//		fail("Not yet implemented");
//	}
//	
//	@Test 
//	public void testCategoryWrongFile() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddQuestions() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testReadData() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testShuffle() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testPrintQuestionsAndCorrectAnswers() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testPrintQuestionAndAllAnswers() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testPrintQuestionAndAllAnswersQuestion() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testPrintIncorrectAnswers() {
//		fail("Not yet implemented");
//	}

}
