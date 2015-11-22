//package ua.com.goit.gojava7.kickstarter.view;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//import static org.mockito.Matchers.contains;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//
//import java.io.PrintStream;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import ua.com.goit.gojava7.kickstarter.beans.Quote;
//import ua.com.goit.gojava7.kickstarter.storage_in_files.FaqStorage;
//import ua.com.goit.gojava7.kickstarter.storage_in_files.PaymentStorage;
//import ua.com.goit.gojava7.kickstarter.beans.Category;
//import ua.com.goit.gojava7.kickstarter.beans.Faq;
//import ua.com.goit.gojava7.kickstarter.beans.Payment;
//import ua.com.goit.gojava7.kickstarter.beans.Project;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ConsolePrinterTest {
//
//	private ConsolePrinter consolePrinter;
//	private PrintStream defaultSystemOut;
//		
//	@Mock
//	private PrintStream printSteam;
//
//	
//	@Before
//	public void setUp() throws Exception {
//		consolePrinter = new ConsolePrinter();
//		defaultSystemOut = System.out;
//		System.setOut(printSteam);
//	}
//	
//	@Test
//	public void testPrintQuote() {
//		String quoteText = "Hello world!";
//		String author = "Anton Smirnov";
//		Quote quote = new Quote(quoteText, author);
//		
//		consolePrinter.print(quote);
//
//		verify(printSteam).println(contains(quoteText));
//		verify(printSteam).println(contains(author));
//		verify(printSteam).println(contains("(c)"));
//	}
//
//	@Test
//	public void testPrintCategory() {
//		String categoryName = "Stars";
//		Category category = new Category(categoryName);
//		
//		consolePrinter.print(category);
//		
//		verify(printSteam).println(contains(categoryName));	
//	}
//
//	@Test
//	public void testPrintString() {
//		String line = "Some text...";
//		consolePrinter.print(line);
//		verify(printSteam).println(line);
//	}
//
//	@Test
//	public void testPrintShortProjectInfo() {
//		String title = "Soccer game";
//		String shortDescription = "The best game...";
//		int requiredSum = 1_000_000;
//		int projectID = 1;
//		
//		String userName = "Anton";
//		long creditCardNumber = 123456789;
//		int donatingSum = 1000;
//		
//		Project project = new Project(title, shortDescription, requiredSum);
//		project.setUniqueID(projectID);
//		
//		Payment payment = new Payment(userName, creditCardNumber, donatingSum);
//		payment.setProjectID(projectID);
//		
//		PaymentStorage paymentStorage = new PaymentStorage();
//		paymentStorage.add(payment);
//		
//		FaqStorage faqStorage = new FaqStorage();
//		
//		consolePrinter.printShortProjectInfo(project, faqStorage, paymentStorage);
//		
//		verify(printSteam).println(contains("Title : "));
//		verify(printSteam).println(contains("Short description : "));
//		verify(printSteam).println(contains("Required amount : "));
//		verify(printSteam).println(contains("Gathered amount : "));
//		verify(printSteam).println(contains("Days left : "));
//	}
//
//	@Test
//	public void testPrintFullProjectInfo() {
//		String title = "Soccer game";
//		String shortDescription = "The best game...";
//		int requiredSum = 1_000_000;
//		int projectID = 1;
//		
//		String userName = "Anton";
//		long creditCardNumber = 123456789;
//		int donatingSum = 1000;
//		
//		String question = "How are you?";
//		
//		Project project = new Project(title, shortDescription, requiredSum);
//		project.setUniqueID(projectID);
//		
//		Payment payment = new Payment(userName, creditCardNumber, donatingSum);
//		payment.setProjectID(projectID);
//		
//		PaymentStorage paymentStorage = new PaymentStorage();
//		paymentStorage.add(payment);
//		
//		Faq faq = new Faq(question);
//		faq.setProjectID(projectID);
//		
//		FaqStorage faqStorage = new FaqStorage();
//		faqStorage.add(faq);	
//		
//		consolePrinter.printFullProjectInfo(project, faqStorage, paymentStorage);
//		
//		verify(printSteam).println(contains("Title : "));
//		verify(printSteam).println(contains("Short description : "));
//		verify(printSteam).println(contains("Required amount : "));
//		verify(printSteam).println(contains("Gathered amount : "));
//		verify(printSteam).println(contains("Days left : "));
//		verify(printSteam).println(contains("History : "));
//		verify(printSteam).println(contains("Video : "));
//	}
//
//	@Test
//	public void testPrintCategories() {
//		List<Category> categories = new ArrayList<>();
//		
//		String categoryName1 = "Stars";
//		String categoryName2 = "Movie";
//		Category category1 = new Category(categoryName1);
//		Category category2 = new Category(categoryName2);
//		
//		categories.add(category1);
//		categories.add(category2);
//		
//		consolePrinter.printCategories(categories);
//		
//		verify(printSteam).println(contains("All categories : "));
//		verify(printSteam).println(contains(String.valueOf(String.valueOf(1))));
//		verify(printSteam).println(contains(String.valueOf(String.valueOf(2))));
//	}
//
//	@Test
//	public void testPrintProjects() {		
//		String title = "Soccer game";
//		String shortDescription = "The best game...";
//		int requiredSum = 1_000_000;
//		int projectID = 1;
//		
//		String userName = "Anton";
//		long creditCardNumber = 123456789;
//		int donatingSum = 1000;
//		
//		String question = "How are you?";
//		
//		Project project = new Project(title, shortDescription, requiredSum);
//		project.setUniqueID(projectID);
//		
//		List<Project> projects = new ArrayList<>();
//		projects.add(project);
//		
//		Payment payment = new Payment(userName, creditCardNumber, donatingSum);
//		payment.setProjectID(projectID);
//		
//		PaymentStorage paymentStorage = new PaymentStorage();
//		paymentStorage.add(payment);
//		
//		Faq faq = new Faq(question);
//		faq.setProjectID(projectID);
//		
//		FaqStorage faqStorage = new FaqStorage();
//		faqStorage.add(faq);	
//		
//		consolePrinter.printProjects(projects, faqStorage, paymentStorage);
//		
//		verify(printSteam).println(contains("Title : "));
//		verify(printSteam).println(contains("Short description : "));
//		verify(printSteam).println(contains("Required amount : "));
//		verify(printSteam).println(contains("Gathered amount : "));
//		verify(printSteam).println(contains("Days left : "));
//	}
//
//	@Test
//	public void testPrintFAQs() {
//		
//		String question = "How are you?";
//		
//		String title = "Soccer game";
//		String shortDescription = "The best game...";
//		int requiredSum = 1_000_000;
//		int projectID = 1;
//				
//		Project project = new Project(title, shortDescription, requiredSum);
//		project.setUniqueID(projectID);
//		
//		Faq faq = new Faq(question);
//		faq.setProjectID(projectID);
//		
//		FaqStorage faqStorage = new FaqStorage();
//		faqStorage.add(faq);	
//		
//		consolePrinter.printFAQs(faqStorage, project);
//		
//		verify(printSteam).println(contains("FAQ : "));
//	}
//
//}
