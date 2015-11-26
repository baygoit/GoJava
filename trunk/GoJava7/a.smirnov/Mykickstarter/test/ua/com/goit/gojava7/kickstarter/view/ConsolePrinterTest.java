package ua.com.goit.gojava7.kickstarter.view;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.com.goit.gojava7.kickstarter.beans.*;
import ua.com.goit.gojava7.kickstarter.dao.memory.CategoryDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.FaqDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.PaymentDaoMemoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class ConsolePrinterTest {

	private ConsolePrinter consolePrinter;
		
	@Mock
	private PrintStream printSteam;

	
	@Before
	public void setUp() throws Exception {
		consolePrinter = new ConsolePrinter();
		System.setOut(printSteam);
	}
	
	@Test
	public void testPrintQuote() {
		String quoteText = "Hello world!";
		String author = "Anton Smirnov";
		Quote quote = new Quote(quoteText, author);
		
		consolePrinter.print(quote);

		verify(printSteam).println(contains(quoteText));
		verify(printSteam).println(contains(author));
		verify(printSteam).println(contains("(c)"));
	}

	@Test
	public void testPrintCategory() {
		String categoryName = "Stars";
		Category category = new Category(categoryName);
		
		consolePrinter.print(category);
		
		verify(printSteam).println(contains(categoryName));	
	}

	@Test
	public void testPrintString() {
		String line = "Some text...";
		consolePrinter.print(line);
		verify(printSteam).println(line);
	}

	@Test
	public void testPrintShortProjectInfo() {
		String title = "Soccer game";
		String shortDescription = "The best game...";
		int requiredSum = 1_000_000;
		int projectID = 1;
		
		String userName = "Anton";
		long creditCardNumber = 123456789;
		int donatingSum = 1000;
		
		Project project = new Project(title, shortDescription, requiredSum);
		project.setUniqueID(projectID);
		
		Payment payment = new Payment(userName, creditCardNumber, donatingSum);
		payment.setProjectID(projectID);
		
		PaymentDaoMemoryImpl paymentStorage = new PaymentDaoMemoryImpl();
		paymentStorage.add(payment);
		
		FaqDaoMemoryImpl faqStorage = new FaqDaoMemoryImpl();
		
		consolePrinter.printShortProjectInfo(project, faqStorage, paymentStorage);
		
		verify(printSteam).println(contains("Title : "));
		verify(printSteam).println(contains("Short description : "));
		verify(printSteam).println(contains("Required amount : "));
		verify(printSteam).println(contains("Gathered amount : "));
		verify(printSteam).println(contains("Days left : "));
	}

	@Test
	public void testPrintFullProjectInfo() {
		String title = "Soccer game";
		String shortDescription = "The best game...";
		int requiredSum = 1_000_000;
		int projectID = 1;
		
		String userName = "Anton";
		long creditCardNumber = 123456789;
		int donatingSum = 1000;
		
		String question = "How are you?";
		
		Project project = new Project(title, shortDescription, requiredSum);
		project.setUniqueID(projectID);
		
		Payment payment = new Payment(userName, creditCardNumber, donatingSum);
		payment.setProjectID(projectID);
		
		PaymentDaoMemoryImpl paymentStorage = new PaymentDaoMemoryImpl();
		paymentStorage.add(payment);
		
		Faq faq = new Faq(question);
		faq.setProjectID(projectID);
		
		FaqDaoMemoryImpl faqStorage = new FaqDaoMemoryImpl();
		faqStorage.add(faq);	
		
		consolePrinter.printFullProjectInfo(project, faqStorage, paymentStorage);
		
		verify(printSteam).println(contains("Title : "));
		verify(printSteam).println(contains("Short description : "));
		verify(printSteam).println(contains("Required amount : "));
		verify(printSteam).println(contains("Gathered amount : "));
		verify(printSteam).println(contains("Days left : "));
		verify(printSteam).println(contains("Video : "));
	}

	@Test
	public void testPrintCategories() {
		String categoryName1 = "Stars";
		String categoryName2 = "Movie";
		Category category1 = new Category(categoryName1);
		Category category2 = new Category(categoryName2);
		
		CategoryDaoMemoryImpl categoriesStorage = new CategoryDaoMemoryImpl();
		categoriesStorage.add(category1);
		categoriesStorage.add(category2);
		consolePrinter.printCategories(categoriesStorage);
		
		verify(printSteam).println(contains("All categories : "));
		verify(printSteam).println(contains(String.valueOf(String.valueOf(1))));
		verify(printSteam).println(contains(String.valueOf(String.valueOf(2))));
	}

	@Test
	public void testPrintProjects() {		
		String title = "Soccer game";
		String shortDescription = "The best game...";
		int requiredSum = 1_000_000;
		int projectID = 1;
		
		String userName = "Anton";
		long creditCardNumber = 123456789;
		int donatingSum = 1000;
		
		String question = "How are you?";
		
		Project project = new Project(title, shortDescription, requiredSum);
		project.setUniqueID(projectID);
		
		List<Project> projects = new ArrayList<>();
		projects.add(project);
		
		Payment payment = new Payment(userName, creditCardNumber, donatingSum);
		payment.setProjectID(projectID);
		
		PaymentDaoMemoryImpl paymentStorage = new PaymentDaoMemoryImpl();
		paymentStorage.add(payment);
		
		Faq faq = new Faq(question);
		faq.setProjectID(projectID);
		
		FaqDaoMemoryImpl faqStorage = new FaqDaoMemoryImpl();
		faqStorage.add(faq);	
		
		consolePrinter.printProjects(projects, faqStorage, paymentStorage);
		
		verify(printSteam).println(contains("Title : "));
		verify(printSteam).println(contains("Short description : "));
		verify(printSteam).println(contains("Required amount : "));
		verify(printSteam).println(contains("Gathered amount : "));
		verify(printSteam).println(contains("Days left : "));
	}
}
