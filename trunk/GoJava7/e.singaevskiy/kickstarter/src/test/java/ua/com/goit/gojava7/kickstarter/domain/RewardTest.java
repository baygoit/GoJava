package ua.com.goit.gojava7.kickstarter.domain;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEqualsFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardTest {

    @Test
    public void testBean() {
        assertThat(Reward.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(),
                hasValidBeanHashCodeFor("id"), hasValidBeanEqualsFor("id"),
                hasValidBeanToString()
        ));

    }

    @Test
    public void testConstructor() {
        int projectId = 42;
        long pledgeSum = 100L;
        String description = "d1";
        Reward reward = new Reward(1, projectId, description, pledgeSum);
        assertThat(reward.getProjectId(), is(projectId));
        assertThat(reward.getDescription(), is(description));
        assertThat(reward.getPledgeSum(), is(pledgeSum));
    }

}
