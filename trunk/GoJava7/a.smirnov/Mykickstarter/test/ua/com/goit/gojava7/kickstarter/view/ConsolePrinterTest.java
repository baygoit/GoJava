package ua.com.goit.gojava7.kickstarter.view;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.CORBA.portable.OutputStream;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.storage.CategoriesStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuotesStorage;

public class ConsolePrinterTest {
	static CategoriesStorage categoriesStorage;
	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	PrintStream printStream = new PrintStream(outputStream);
	ConsolePrinter consolePrinter = new ConsolePrinter(printStream);
	static Quote qoute1; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		categoriesStorage = new CategoriesStorage();
		Category category1 = new Category("First");
		Category category2 = new Category("Second");
		
		qoute1 = new Quote("Anton", "ttt");
//		Quote quote2 = new Quote("Vova", "123");
		
		categoriesStorage.addCategory(category1);
		categoriesStorage.addCategory(category2);
	
	}

	@Test
	public void testPrintQuote() {
		consolePrinter.print(qoute1);
		assertThat(outputStream.toString().contains(qoute1.getAuthor()), is (true));
	}

	@Test
	public void testPrintCategories() {
		consolePrinter.printCategories(categoriesStorage.getAllCategories());
		for (Category category : categoriesStorage.getAllCategories()) {
			assertThat(outputStream.toString().contains(category.getName()), is(true));
		}
	}

	@Test
	public void testPrintProjects() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBriefInfoProject() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintFullInfoProject() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintString() {
		fail("Not yet implemented");
	}

}
