package ua.com.goit.gojava7.kickstarter.beans;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.mockito.Mockito;

public class RewardTest {

    @Test
    public void testBean() {
        assertThat(Reward.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters()
        /*
         hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()
         */
        ));

    }
    
    @Test
    public void testConstructor() {
        Project project = Mockito.mock(Project.class);
        long pledgeSum = 100L;
        String description = "d1";
        Reward reward = new Reward(project, description, pledgeSum);
        assertThat(reward.getProject(), is(project));
        assertThat(reward.getDescription(), is(description));
        assertThat(reward.getPledgeSum(), is(pledgeSum));
    }

}
