package ua.com.goit.gojava7.kikstarter;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kikstarter.domain.Quote;


public class QuoteTest {

	private Quote quoteTest;
	
	@Before
	public void setObjectQuote(){
		quoteTest=new Quote("Life ia good!", "Human");
		quoteTest.setContent("Life is very good!");
		quoteTest.setAuthor("Sinlge human");
	}
	
	@Test
	public void test() {
		assertThat(quoteTest.getContent(), is("Life is very good!"));
		assertThat(quoteTest.getAuthor(), is("Sinlge human"));
		assertThat(quoteTest.toString(), is("\nContent: Life is very good!" + "\nAuthor: Sinlge human"));
	}

}
