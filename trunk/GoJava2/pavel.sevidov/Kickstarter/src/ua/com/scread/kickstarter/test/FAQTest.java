package ua.com.scread.kickstarter.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.com.scread.kickstarter.FAQ;

public class FAQTest {
	FAQ faq = new FAQ("question", "answer");
	
	@Test
	public void shouldBeQuestion_whenGetQuestion() {
		assertEquals("question", faq.getQuestion());
	}
	
	@Test
	public void shouldBeAnswer_whenGetAnswer() {
		assertEquals("answer", faq.getAnswer());
	}

}
