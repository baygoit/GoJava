package ua.com.scread.kickstarter.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.com.scread.kickstarter.Details;
import ua.com.scread.kickstarter.FAQ;

public class DetailsTest {
	FAQ faq = new FAQ("question", "answer");
	Details details = new Details("history", "video", faq);
	
	@Test
	public void shouldBeHistory_whenGetHistory() {
		assertEquals("history", details.getHistory());
	}
	
	@Test
	public void shouldBeVideo_whenGetVideo() {
		assertEquals("video", details.getVideo());
	}
}
