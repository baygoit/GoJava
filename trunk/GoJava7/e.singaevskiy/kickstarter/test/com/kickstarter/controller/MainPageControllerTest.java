package com.kickstarter.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.kickstarter.beans.Category;
import com.kickstarter.beans.Project;
import com.kickstarter.beans.Quote;
import com.kickstarter.dao.CategoryDAO;
import com.kickstarter.dao.ProjectDAO;
import com.kickstarter.dao.QuoteDAO;
import com.kickstarter.view.MainPage;

public class MainPageControllerTest {

	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private ByteArrayInputStream inContent = new ByteArrayInputStream(("1\n"
			+ "1\n"
			+ "1\n"
			+ "user 123123123 200\n"
			+ "0\n"
			+ "0\n"
			+ "0\n").getBytes());
	private MainPageController controller = new MainPageController(new MainPage(new PrintStream(outContent)), inContent);
	
	@Test
	public void showCategories() {
		List<Category> categories = new CategoryDAO().getAll();
		controller.printCategories(categories);
		assertTrue(outContent.toString().indexOf("Categories")>0);
		categories.forEach(cat -> assertTrue(outContent.toString().indexOf(cat.getName())>0));
	}
	
	@Test
	public void showMainPage() {
		controller.showMainPage();
		assertThat(outContent.toString().isEmpty(), is(false));
	}
	
	@Test
	public void processPaymentRequest() {
		Project project = new Project();
		project.setBalanceSum(0L);
		
		String paymentRequest = "John 1231231231 200";
		assertThat("Payment is valid", controller.processPayment(project, paymentRequest), is(true));
		assertThat("Payment done", project.getBalanceSum(), is(200L));
		
		paymentRequest = "John 1231231231 300";
		assertThat("Payment is valid", controller.processPayment(project, paymentRequest), is(true));
		assertThat("Payment done", project.getBalanceSum(), is(500L));
	}
	
	@Test
	public void processPaymentRequestError() {
		String paymentRequest = "John 1231231231 200f";
		Project project = new ProjectDAO().get(0);
		assertThat("Payment is not valid", controller.processPayment(project, paymentRequest), is(false));
	}
	
	@Test
	public void invalidPaymentTest() {
		inContent = new ByteArrayInputStream(("1\n1\n1\n"
				+ "user 123123123\n"
				+ "user 123123123 200f\n"
				+ "user 123123123 200\n"
				+ "0\n0\n0\n").getBytes());
		controller = new MainPageController(new MainPage(new PrintStream(outContent)), inContent);
		controller.showMainPage();
		assertTrue(true);
	}
	
	@Test
	public void invalidInputTest() {
		inContent = new ByteArrayInputStream("1\n-11\nqwe\n0\n0\n".getBytes());
		controller = new MainPageController(new MainPage(new PrintStream(outContent)), inContent);
		controller.showMainPage();
		assertTrue(true);
	}
	
	@Test
	public void showRandomQuote() {
		
		@SuppressWarnings("serial")
		Random rnd = new Random(){
			int val = -1;
			@Override
			public int nextInt(int bound) {
				if (val >= bound-1) {
					val=0;
				} else {
					val++;
				}
				return val;
			}
			
		};
		
		List<Quote> all = new QuoteDAO().getAll();
		
		int foundIndex;
		int lastIndex=0;
		for (int i = 0; i < all.size(); i++) {
			controller.showRandomQuote(rnd);
			Quote element = all.get(i);
			foundIndex = outContent.toString().substring(lastIndex).indexOf(element.getText());
			assertThat(foundIndex, not(-1));
			lastIndex += foundIndex + element.getText().length();		
		}

	}
	
}
