package ua.com.goit.gojava7.kikstarter;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

public class PaymentTest {

	Payment paymentTest;
	
	@Before
	public void setObjectPayment(){
		paymentTest=new Payment("Human", 101020204040l, 500);
		paymentTest.setPaymentUserName("Human");
		paymentTest.setPaymentNumberCard(101020204040l);
		paymentTest.setPaymentEntered(600);
	}
	
	@Test
	public void test(){
		assertThat(paymentTest.getPaymentUserName(), is("Human"));
		assertThat(paymentTest.getPaymentNumberCard(), is(101020204040l));
		assertThat(paymentTest.getPaymentEntered(), is(600));
	}
	
}
