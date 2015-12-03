package ua.com.goit.gojava7.kickstarter.dao.memory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Project;

public class FaqMemoryDAOTest {

	private FaqDaoMemoryImpl faqMemory = new FaqDaoMemoryImpl();
	private Faq faq = new Faq();
	private Project project = new Project();
	private int projectID = 1;
	
	@Before
	public void setUp() throws Exception {
		faq.setProjectID(projectID);
		project.setUniqueID(projectID);
	}

	@Test
	public void testFaqMemoryDAO() {
		assertThat(faqMemory.getSize(), is(0));
	}
	
	@Test
	public void testGetProjectFaqs() {
		faqMemory.add(faq);
		assertEquals(faqMemory.getProjectFaqs(project).contains("question"), true);
		assertEquals(faqMemory.getProjectFaqs(project).contains("answer"), true);
	}

	@Test
	public void testAdd() {
		faqMemory.add(faq);
		
		assertThat(faqMemory.getSize(), is(1));
		assertThat(faqMemory.getAll().get(0).getQuestion().length(), is(0));
		assertThat(faqMemory.getAll().get(0).getAnswer().length(), is(0));
		assertThat(faqMemory.getAll().get(0).getProjectID(), is(projectID));
	}

	@Test
	public void testRemove() {
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
