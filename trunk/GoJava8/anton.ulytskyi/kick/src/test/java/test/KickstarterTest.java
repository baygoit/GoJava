package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kickstarter.domain.Accounting;
import kickstarter.domain.Category;
import kickstarter.domain.Comments;
import kickstarter.domain.Project;
import kickstarter.domain.Quote;
import kickstarter.manager.Manager;

public class KickstarterTest {
	
	int expectedNumber = 1;
	String expectedText = "expected";
	Date expectedDate = new Date();

	Accounting accounting = new Accounting();
	Category category = new Category();
	Comments comments = new Comments();
	Project project = new Project();
	Quote quote = new Quote();

	Manager operator = new Manager();

	@Before
	public void changeSettingOfSpring() {

		operator.ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
				"file:src/test/resources/spring.xml");
	}

	
	@Test
	public void quoteTest() {

		String quote = operator.getRandomQuote();

		if ("quote1".equals(quote)) {
			assertEquals(quote, "quote1");
		} else {
			assertEquals(quote, "quote2");
		}
	}


	@Test
	public void categoriesTest() {

		List<String> categories = operator.getAllCategories();
		assertEquals(categories.get(0), "category1");
		assertEquals(categories.get(1), "category2");
	}

	
	@Test
	public void projectsTest() {

		String expectation = "project1";

		HashMap<Integer, String> projects = operator
				.getAllProjectsByCategory("category1");
		String reality = projects.get(1);
		assertEquals(reality.contains(expectation), true);

	}

	
	@Test
	public void openProjectTest() {

		String expectationName = "project1";
		List<String> category = operator.openProject(1);
		String name = category.get(0);

		assertEquals(name, expectationName);
	}

	@Test
	public void sponsorTest() {

		int difference = 1;
		int id = 1;
		int before = operator.getMoneyCollected(id);
		operator.sponsor(id, 1);
		int after = operator.getMoneyCollected(1);

		assertEquals(after - before, difference);

	}

	@Test
	public void commentTest() {
		int id = 1;
		Date testTime = new Date();
		String testAuthor = "test(" + testTime.getMinutes() + ":"
				+ testTime.getSeconds() + ")";
		String testText = "" + testTime.getTime();
		operator.addCommentTo(id, testAuthor, testText);
		
		String testProject = (operator.openProject(id)).toString();
		assertEquals(testProject.contains(testText), true);

	}
	
	@Test
	public void accountingDomainTest() {

		accounting.setInvoice(expectedNumber);
		accounting.setId(expectedNumber);
		accounting.setAmount(expectedNumber);
		accounting.setDate(expectedDate);

		assertEquals(accounting.getAmount(), expectedNumber);
		assertEquals(accounting.getId(), expectedNumber);
		assertEquals(accounting.getInvoice(), expectedNumber);
		assertEquals(accounting.getDate(), expectedDate);
	}

	@Test
	public void categoryDomainTest() {

		category.setCategory(expectedText);
		category.setId(expectedNumber);

		assertEquals(category.getCategory(), expectedText);
		assertEquals(category.getId(), expectedNumber);
	}

	@Test
	public void commentsDomainTest() {

		comments.setAuthor(expectedText);
		comments.setDate(expectedDate);
		comments.setId(expectedNumber);
		comments.setNumber(expectedNumber);
		comments.setText(expectedText);

		assertEquals(comments.getAuthor(), expectedText);
		assertEquals(comments.getDate(), expectedDate);
		assertEquals(comments.getId(), expectedNumber);
		assertEquals(comments.getText(), expectedText);
		assertEquals(comments.getNumber(), expectedNumber);
	}

	@Test
	public void commentsDomainProject() {

		project.setCategory(expectedText);
		project.setHistory(expectedText);
		project.setId(expectedNumber);
		project.setName(expectedText);
		project.setNeedMoney(expectedNumber);
		project.setStart(expectedDate);
		project.setUrl(expectedText);

		assertEquals(project.getCategory(), expectedText);
		assertEquals(project.getHistory(), expectedText);
		assertEquals(project.getId(), expectedNumber);
		assertEquals(project.getName(), expectedText);
		assertEquals(project.getNeedMoney(), expectedNumber);
		assertEquals(project.getStart(), expectedDate);
		assertEquals(project.getUrl(), expectedText);

	}

	@Test
	public void commentsDomainQuote() {

		quote.setId(expectedNumber);
		quote.setQuote(expectedText);

		assertEquals(quote.getId(), expectedNumber);
		assertEquals(quote.getQuote(), expectedText);
	}
}

