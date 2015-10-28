package goit.nz.kickstartermvc.test.dao;

import goit.nz.kickstartermvc.dao.FAQ;
import static org.junit.Assert.*;

import org.junit.Test;

public class FAQTest {

	@Test
	public void whenAnswerIsEmptyThenNotYetAnsweredReturned() {
		FAQ testFAQ = new FAQ("test question");
		
		String expected = "not yet answered...";
		
		String actual = testFAQ.getAnswer();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenAnswerAddedThentAnswerReturned() {
		FAQ testFAQ = new FAQ("test question");
		String testAnswer = "test answer";
		testFAQ.setAnswer(testAnswer);
		
		String expected = testAnswer;
		
		String actual = testFAQ.getAnswer();
		
		assertEquals(expected, actual);
	}

}
