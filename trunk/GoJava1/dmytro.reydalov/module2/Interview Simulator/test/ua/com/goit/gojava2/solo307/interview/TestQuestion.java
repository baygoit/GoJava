package ua.com.goit.gojava2.solo307.interview;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestQuestion {
	
	Question question;
	
	@Before
	public void setUp() throws Exception {
		List <Answer> answers = new ArrayList<Answer>();
		answers.add(new Answer(1, "Процедурность, инкапсуляция, полиморфизм.", false));
		answers.add(new Answer(2, "Инкапсуляция, полиморфизм, наследование.", true));
		answers.add(new Answer(3, "Обьектность, ориентированность, программированность.", false));
		answers.add(new Answer(4, "Яйка, млако , колбаса.", false));
		question = new Question("Какие 3 принципа Обьектно - ориентированного программирования?", answers ,1 );
	}

	@Test
	public void testReadInt() {
		int expected = 2;
		int actual = question.readAnswer();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testReadIntTryNotNumber(){
		int expected = 0;
		int actual = question.readAnswer();
		assertEquals(actual, expected);
	}
	
	@Test
	public void testReadIntTryNotExistiong(){
		int expected = 0;
		int actual = question.readAnswer();
		assertEquals(actual, expected);
	}
	
	@Test
	public void testIsAnswerIdExists(){
		int wrongNumber = 5;
		boolean expected = false;
		boolean actual = question.isAnswerIdExists(wrongNumber);
		assertEquals(expected, actual);
	}
}
