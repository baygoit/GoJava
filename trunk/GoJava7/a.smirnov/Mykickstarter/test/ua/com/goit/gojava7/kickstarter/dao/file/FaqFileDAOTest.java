package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Project;

public class FaqFileDAOTest {

	private FaqDaoFileImpl faqFile = new FaqDaoFileImpl();
	private Faq faq = new Faq();
	private Project project = new Project();
	
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
