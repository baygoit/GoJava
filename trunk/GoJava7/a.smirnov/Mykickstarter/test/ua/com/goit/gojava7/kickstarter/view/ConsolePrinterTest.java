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
import ua.com.goit.gojava7.kickstarter.storage_in_files.CategoriesStorage;
import ua.com.goit.gojava7.kickstarter.storage_in_files.QuotesStorage;

public class ConsolePrinterTest {
	static CategoriesStorage categoriesStorage;
	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	PrintStream printStream = new PrintStream(outputStream);

	static Quote qoute1; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		categoriesStorage = new CategoriesStorage();
		Category category1 = new Category("First");
		Category category2 = new Category("Second");
		
		qoute1 = new Quote("Anton", "ttt");
//		Quote quote2 = new Quote("Vova", "123");
		
//		categoriesStorage.addCategory(category1);
//		categoriesStorage.addCategory(category2);
//	
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
