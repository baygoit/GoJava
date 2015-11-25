package ua.com.goit.gojava7.kickstarter.dao.memory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Project;

public class FaqMemoryDAOTest {

	private FaqMemoryDAO faqMemory;
	@Before
	public void setUp() throws Exception {
		faqMemory = new FaqMemoryDAO();
	}

	@Test
	public void testGetProjectFaqs() {
		int projectID = 0;
		Project project = new Project("Project 1", "XXX", 10_000);
		project.setUniqueID(projectID);
		
		String question = "Hello amigo";
		Faq faq = new Faq(question);
		faq.setProjectID(projectID);

		assertEquals(faqMemory.getProjectFaqs(project).contains("question"), true);
	}

	@Test
	public void testAdd() {
		String question = "Hello amigo";
		int projectID = 1;
		Faq faq = new Faq(question);
		faq.setProjectID(projectID);
		
		faqMemory.add(faq);
		
		assertThat(faqMemory.getSize(), is(1));
		assertThat(faqMemory.getAll().get(0).getQuestion(), is(question));
		assertThat(faqMemory.getAll().get(0).getProjectID(), is(projectID));
	}

	@Test
	public void testRemove() {
		String question = "Hello amigo";
		int projectID = 1;
		Faq faq = new Faq(question);
		faq.setProjectID(projectID);
		
		faqMemory.add(faq);
		assertThat(faqMemory.getSize(), is(1));
		
		faqMemory.remove(faq);
		assertThat(faqMemory.getSize(), is(0));
	}

	@Test
	public void testGetAll() {
		assertThat(faqMemory.getAll().size(), is(0));
	}

	@Test
	public void testGetSize() {
		assertThat(faqMemory.getSize(), is(0));
	}

}
