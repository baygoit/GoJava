package ua.com.goit.gojava7.kickstarter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuestionStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuoteStorage;

public class KickstarterTest{
	QuestionStorage questionStorage;
	CategoryStorage categoryStorage;
	Body body = new Body();
	ProjectStorage projectStorage;
	QuoteStorage quoteStorage;
	Kickstarter kickstarter;
	DataSource dataSource = DataSource.MEMORY;
	DaoFactory daoFactory = new DaoFactory(dataSource);
	@Before
	public void setUp(){
		
		questionStorage = daoFactory.getQuestionsStorage();
		categoryStorage = daoFactory.getCategoryStorage();
		projectStorage = daoFactory.getProjectStorage();
		quoteStorage = daoFactory.getQuoteStorage();
		kickstarter = new Kickstarter(quoteStorage, categoryStorage, body, projectStorage, questionStorage);
	}
	@Test
	public void testKickstarter() {
		assertNotNull(kickstarter);
	}

	@Test
	public void testGetQuoteStorage() {
		assertThat(kickstarter.getQuoteStorage(),is(daoFactory.getQuoteStorage()));
	}

	@Test
	public void testGetBody() {
		assertThat(kickstarter.getBody(),is(body));
	}



	@Test
	public void testGetCategoryStorage() {
		assertThat(kickstarter.getCategoryStorage(),is(daoFactory.getCategoryStorage()));
	}



	@Test
	public void testGetProjectManager() {
		assertThat(kickstarter.getProjectManager(),is(daoFactory.getProjectStorage()));
	}



	@Test
	public void testRun() {
		fail("Not yet implemented");
	}

	@Test
	public void testShutdown() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetQuestionStorage() {
		assertThat(kickstarter.getQuestionStorage(), is(daoFactory.getQuestionsStorage()));
	}



}
