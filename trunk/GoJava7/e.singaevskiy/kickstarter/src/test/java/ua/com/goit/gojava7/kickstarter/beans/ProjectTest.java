package ua.com.goit.gojava7.kickstarter.beans;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectTest {

    @Test
    public void testBean() {
        assertThat(Project.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters()
        ));

    }

}
