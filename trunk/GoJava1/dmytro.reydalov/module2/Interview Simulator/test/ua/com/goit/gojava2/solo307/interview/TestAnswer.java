package ua.com.goit.gojava2.solo307.interview;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestAnswer {
	
	Answer answerDefault;
	Answer answerAll;
	
	@Before
	public void setUp(){
		answerDefault = new Answer();
		answerAll = new Answer('s', "My Answer", true);
	}
	
	@Test
	public void testAnswer() {
		String text =  "there is an answer must be here...";
		boolean isCorrect = false;
		char id = 0;
		assertEquals(text, answerDefault.getText());
		assertEquals(isCorrect, answerDefault.isAnswerCorrect());
		assertEquals(id, answerDefault.getId());
	}

	@Test
	public void testAnswerStringBooleanChar() {
		String text =  "My Answer";
		boolean isCorrect = true;
		char id = 's';
		assertEquals(text, answerAll.getText());
		assertEquals(isCorrect, answerAll.isAnswerCorrect());
		assertEquals(id, answerAll.getId());
	}
	

	@Test
	public void testGetIdAndAnswer() {
		Answer answer = new Answer('s', "My Answer", true);
		String expected = "s. My Answer" + "\n";
		String actual = answer.getIdAndAnswer();
		assertEquals(expected, actual);
	}

}
