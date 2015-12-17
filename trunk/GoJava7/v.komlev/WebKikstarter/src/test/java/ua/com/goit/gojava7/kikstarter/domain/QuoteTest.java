package ua.com.goit.gojava7.kikstarter.domain;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ua.com.goit.gojava7.kikstarter.domain.Quote;

public class QuoteTest {

	@Test
	public void testDomain(){
		assertThat(Quote.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters()));
	}
	
}
