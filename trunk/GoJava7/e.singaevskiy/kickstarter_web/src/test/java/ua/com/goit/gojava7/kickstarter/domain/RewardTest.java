package ua.com.goit.gojava7.kickstarter.domain;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RewardTest {

    @Test
    public void testBean() {
        assertThat(Reward.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(),
                hasValidBeanHashCode(), hasValidBeanEquals(),
                hasValidBeanToString()
        ));

    }

}
