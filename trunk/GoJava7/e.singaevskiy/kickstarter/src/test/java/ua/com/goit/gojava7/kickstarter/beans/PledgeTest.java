package ua.com.goit.gojava7.kickstarter.beans;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PledgeTest {

    @Test
    public void testBean() {
        assertThat(Pledge.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters()
        /*
         hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()
         */
        ));

    }

}
