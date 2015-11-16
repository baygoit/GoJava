package ua.com.goit.gojava7.kickstarter.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FaqTest {
	
	private Faq faq1;
	private Faq faq2;
	private Project project;
	
	@Before
	public void setUp() throws Exception {
		faq1 = new Faq("How are you?");
		faq2 = new Faq("All is good?");
		project = new Project("1", "2", 3);
		
		faq1.setReceivedQuestionDay();
		faq2.setReceivedQuestionDay();
	}

	@Test
	public void testFaq() {
		Faq faq = new Faq("Hey");
		assertThat(faq.getQuestion(), is ("Hey"));
	}

	@Test
	public void testGetQuestion() {
		assertThat(faq1.getQuestion(), is ("How are you?"));
		assertThat(faq2.getQuestion(), is ("All is good?"));
	}

	@Test
	public void testSetQuestion() {
		faq1.setQuestion("Ukraine?");
		assertThat(faq1.getQuestion(), is ("Ukraine?"));
	}

	@Test (expected = NullPointerException.class)
	public void testGetAnswer() {
		assertThat(faq1.getAnswer().length(), is (0));
	}

	@Test
	public void testSetAnswer() {
		faq1.setAnswer("Yes");
		assertThat(faq1.getAnswer(), is ("Yes"));
	}

	@Test
	public void testSetProject() {
		faq1.setProject(project);
		assertThat(faq1.getProject().getTitle(), is ("1"));
		assertThat(faq1.getProject().getBriefDescription(), is ("2"));
		assertThat(faq1.getProject().getRequiredAmountOfMoney(), is (3));
	}

	@Test
	public void testCompareTo() {
		int result = (int) (faq1.getReceivedQuestionDay().getTimeInMillis() 
								- faq2.getReceivedQuestionDay().getTimeInMillis());
		assertTrue(result == 0);
	}
}
