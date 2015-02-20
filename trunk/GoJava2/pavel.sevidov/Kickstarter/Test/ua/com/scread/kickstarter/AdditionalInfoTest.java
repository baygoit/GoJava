package ua.com.scread.kickstarter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.com.scread.kickstarter.data.AdditionalInfo;
import ua.com.scread.kickstarter.data.Bonus;
import ua.com.scread.kickstarter.data.FAQ;
import ua.com.scread.kickstarter.storage.Bonuses;
import ua.com.scread.kickstarter.storage.FAQs;

public class AdditionalInfoTest {
	FAQs faq = new FAQs(new FAQ("question", "answer"));
	Bonuses bonuses = new Bonuses(new Bonus(50, "Description"));
	AdditionalInfo additionalInfo = new AdditionalInfo("history", "video", bonuses, faq);
	
	@Test
	public void shouldBeHistory_whenGetHistory() {
		assertEquals("history", additionalInfo.getHistory());
	}
	
	@Test
	public void shouldBeVideo_whenGetVideo() {
		assertEquals("video", additionalInfo.getVideo());
	}
	
	@Test
	public void shouldBeFAQ_whenGetFAQ() {
		assertEquals(faq, additionalInfo.getFAQs());
	}
}
