package ua.com.goit.gojava7.kickstarter.domain;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEqualsFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PaymentTest {

    @Test
    public void testBean() {
        assertThat(Payment.class, allOf(hasValidBeanConstructor(),
                hasValidBeanHashCodeFor("id"), 
                hasValidBeanEqualsFor("id"),
                hasValidGettersAndSetters()
        ));

    }

}
