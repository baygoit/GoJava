package com.kickstarter.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kickstarter.beans.Category;
import com.kickstarter.beans.Project;
import com.kickstarter.beans.Quote;
import com.kickstarter.controller.MainPageController;
import com.kickstarter.dao.CategoryDAO;
import com.kickstarter.dao.ProjectDAO;
import com.kickstarter.dao.QuoteDAO;
import com.kickstarter.view.MainPage;

public class MainPageControllerTest {

	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private MainPageController controller = new MainPageController(new MainPage());
	
	@Before
	public void init() {
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanup(){
		System.setOut(null);
	}
	
	@Test
	public void showCategories() {
		List<Category> categories = new CategoryDAO().getAll();
		controller.printCategories(categories);
		assertTrue(outContent.toString().indexOf("Categories")>0);
		categories.forEach(cat -> assertTrue(outContent.toString().indexOf(cat.getName())>0));
	}
	
	@Test
	public void processPaymentRequest() {
		String paymentRequest = "John 1231231231 200";
		Project project = new ProjectDAO().get(0);
		assertThat("Payment is valid", controller.processPayment(project, paymentRequest), is(true));
	}
	
	@Test
	public void processPaymentRequestError() {
		String paymentRequest = "John 1231231231 200f";
		Project project = new ProjectDAO().get(0);
		assertThat("Payment is not valid", controller.processPayment(project, paymentRequest), is(false));
	}
	
	@Test
	public void showRandomQuote() {
		Map<Quote, Integer> mappedQuotes = new HashMap<>();
		new QuoteDAO().getAll().forEach(quote -> mappedQuotes.put(quote, 0));
		int iterations = 10;
		
		int lastIndex=0;
		for (int i = 0; i < iterations; i++) {
			controller.showTopPage();
			
			for (Quote element : mappedQuotes.keySet()) {
				int foundIndex = outContent.toString().substring(lastIndex).indexOf(element.getText());
				if (foundIndex > 0) {
					mappedQuotes.put(element, mappedQuotes.get(element)+1);
					lastIndex += foundIndex + element.getText().length();
					break;
				}
			}
		}

		int count = 0;
		for (Quote element : mappedQuotes.keySet()) {
			assertTrue(mappedQuotes.get(element)<iterations);
			count += mappedQuotes.get(element);
		}
		assertThat(count, is(iterations));

	}
	
}
