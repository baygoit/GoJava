package ua.com.goit.gojava7.kickstarter.beans;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertThat;

import java.sql.Date;

import org.junit.Test;

public class PaymentTest {
	
	Payment testObject = new Payment(null, "testUser", 123, 456, new Date(System.currentTimeMillis()));

    @Test
    public void testBean() {
        assertThat(Payment.class, allOf(hasValidBeanConstructor(),
                hasValidBeanHashCode(), 
                hasValidBeanEquals(),
                hasValidGettersAndSetters()
        ));

    }

}
