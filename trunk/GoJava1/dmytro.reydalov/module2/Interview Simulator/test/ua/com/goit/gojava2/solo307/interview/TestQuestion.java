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
		answers.add(new Answer('a', "Процедурность, инкапсуляция, полиморфизм.", false));
		answers.add(new Answer('b', "Инкапсуляция, полиморфизм, наследование.", true));
		answers.add(new Answer('c', "Обьектность, ориентированность, программированность.", false));
		answers.add(new Answer('d', "Яйка, млако , колбаса.", false));
		question = new Question("Какие 3 принципа Обьектно - ориентированного программирования?", answers ,1 );
	}

}
