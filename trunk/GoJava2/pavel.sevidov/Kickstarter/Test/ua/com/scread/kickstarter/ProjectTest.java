package ua.com.scread.kickstarter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.com.scread.kickstarter.data.AdditionalInfo;
import ua.com.scread.kickstarter.data.Bonus;
import ua.com.scread.kickstarter.data.Category;
import ua.com.scread.kickstarter.data.FAQ;
import ua.com.scread.kickstarter.data.Project;
import ua.com.scread.kickstarter.storage.Bonuses;
import ua.com.scread.kickstarter.storage.FAQs;

public class ProjectTest {
	FAQs faq = new FAQs(new FAQ("question", "answer"));
	Bonuses bonuses = new Bonuses(new Bonus(50, "Description"));
	AdditionalInfo details = new AdditionalInfo("History", "video", bonuses, faq);
	Project project = new Project("Project", "Description", 1, 1, details);

	
	@Test
	public void shouldBeName_whenGetName() {
		String expected = "Project";
		assertEquals(expected, project.getName());
	}
	
	@Test
	public void shouldBeDescription_whenGetDescription() {
		String expected = "Description";
		assertEquals(expected, project.getDescription());
	}
	
	@Test
	public void shouldBeCollected_whenGetCollected() {
		double expected = 0;
		assertEquals(expected, project.getCollected(), 0.1);
	}

	@Test
	public void shouldBeAmount_whenGetAmount() {
		double expected = 1;
		assertEquals(expected, project.getAmount(), 0.1);
	}
	

	@Test
	public void shouldBeDays_whenGetDays() {
		int expected = 1;
		assertEquals(expected, project.getDays());
	}
	
	@Test
	public void shouldBeCategory_whenGetCategory() {
		Category category = new Category("Vasya");
		project.setCategory(category);
		assertEquals(category, project.getCategory());
	}
	
	@Test
	public void shouldBeDetails_whenGetDetails() {
		assertEquals(details ,project.getDetails());
	} // this is test 

}
