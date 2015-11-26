package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Project;

public class FaqFileDAOTest {

	private FaqDaoFileImpl faqFile;
	private Faq faq;
	private Project project;
	
//	@Before
//	public void setUp() throws Exception {
//		faqFile = new FaqDaoFileImpl();
//		faq = new Faq("How are you?");
//		
//		project = new Project("Project 1", "XXX", 10_000);
//		project.setUniqueID(1);
//		faq.setProjectID(1);
//	}

	@Test
	public void testAdd() {
		faqFile.add(faq);
		assertThat(faqFile.getAll().size(), is(1));
	}

	@Test
	public void testGetAll() {
		assertThat(faqFile.getAll().size(), is(1));
	}

	@Test
	public void testGetSize() {
		assertThat(faqFile.getSize(), is(1));
	}
	
	@Test
	public void testGetProjectFaqs() {
		assertEquals(faqFile.getProjectFaqs(project).contains("question : "), true);
	}

}
