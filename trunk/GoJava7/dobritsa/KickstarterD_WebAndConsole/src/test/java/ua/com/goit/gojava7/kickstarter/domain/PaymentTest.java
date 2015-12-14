package ua.com.goit.gojava7.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaymentTest {

	@Mock
	private PrintStream printSteam;
	
	private Payment payment = new Payment();
	
	@Before
	public void testSetUp() {
		payment.setId(1);
		payment.setUser("Nike");
		payment.setCard("1111222233334444");
		payment.setAmount(200);
		payment.setProjectId(33);
		System.setOut(printSteam);
	}
	
	@After
	public void tearDown() {
		verifyNoMoreInteractions(printSteam);
	}
	
	@Test
	public void testGet() {
		assertThat(payment.getId(), is(1));
		assertThat(payment.getUser(), is("Nike"));
		assertThat(payment.getCard(), is("1111222233334444"));
		assertThat(payment.getAmount(), is(200));		
		assertThat(payment.getProjectId(), is(33));
	}
	
	@Test
	public void testToString() {
		System.out.println(payment.toString());
		verify(printSteam).println(contains("Nike"));
	}

}
