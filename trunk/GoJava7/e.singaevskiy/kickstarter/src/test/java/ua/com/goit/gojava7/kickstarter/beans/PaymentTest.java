package ua.com.goit.gojava7.kickstarter.beans;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

public class PaymentTest {
	
	Payment testObject = new Payment(new User("testUser"), 123, 456, new Date());

    @Test
    public void testBean() {
        assertThat(Payment.class, allOf(hasValidBeanConstructor(),
                hasValidBeanHashCode(), hasValidBeanEquals()
        /*
         * , hasValidBeanToString()
         */
        ));

    }
	
	@Test
	public void testGetCardId() {
		long id = 1000;
		testObject.setCardId(id);
		assertThat(testObject.getCardId(), is(id));
	}

	@Test
	public void testGetSum() {
		long sum = 1000;
		testObject.setSum(sum);
		assertThat(testObject.getSum(), is(sum));
	}

	@Test
	public void testGetUser() {
		User user = new User("anotherUser");
		testObject.setUser(user);
		assertThat(testObject.getUser(), is(user));
	}

	@Test
	public void testGetDate() {
		Date date = java.sql.Date.valueOf("2015-10-10");
		testObject.setDate(date);;
		assertThat(testObject.getDate(), is(date));
	}

}
