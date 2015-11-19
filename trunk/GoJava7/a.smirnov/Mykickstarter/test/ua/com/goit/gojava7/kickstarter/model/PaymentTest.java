//package ua.com.goit.gojava7.kickstarter.model;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.*;
//
//import java.util.GregorianCalendar;
//
//import org.junit.Before;
//import org.junit.Test;
//
//public class PaymentTest {
//	
//	Payment payment1;
//	Payment payment2;
//
//	@Before
//	public void setUp() throws Exception {
//		payment1 = new Payment("Anton", 12345, 50);
//		payment2 = new Payment("Oleg", 12121, 100);
//	}
//
//	@Test
//	public void testPayment() {
//		Payment payment = new Payment("A", 1, 1);
//		assertThat(payment.getUserName(), is ("A"));
//		assertThat(payment.getDonatingSum(), is (1));
//		payment.setPaymentDay();
//	}
//
//	@Test
//	public void testGetCreditCardNumber() {
//		assertThat((int)payment1.getCreditCardNumber(), is (12345));
//	}
//
//	@Test
//	public void testSetCreditCardNumber() {
//		payment1.setCreditCardNumber(111);
//		assertThat((int)payment1.getCreditCardNumber(), is (111));
//	}
//
//	@Test
//	public void testGetUserName() {
//		assertThat(payment1.getUserName(), is ("Anton"));
//	}
//
//	@Test
//	public void testSetUserName() {
//		payment1.setUserName("User");
//		assertThat(payment1.getUserName(), is ("User"));
//	}
//
//	@Test
//	public void testGetDonatingSum() {
//		assertThat(payment1.getDonatingSum(), is (50));
//	}
//
//	@Test
//	public void testSetDonatingSum() {
//		payment1.setDonatingSum(100);
//		assertThat(payment1.getDonatingSum(), is (100));
//	}
//
//	@Test
//	public void testGetPaymentDate() {
//		GregorianCalendar calendar = new GregorianCalendar();
//		int result = (int) (payment1.getPaymentDate().getTimeInMillis() - calendar.getTimeInMillis());
//		assertThat(result, is (0));
//	}
//
//	@Test
//	public void testCompareTo() {
//		int result = (int) (payment1.getPaymentDate().getTimeInMillis() - payment2.getPaymentDate().getTimeInMillis());
//		assertThat(result, is (0));
//	}
//
//}
