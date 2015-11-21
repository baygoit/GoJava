package ua.com.goit.gojava7.kickstarter.beans;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class QuestionsTest {
	
    @Test
    public void testConstructor() {
        
        Project project = new Project();
        Question question = new Question(project , "q1","a1");
        
        assertThat(question.getProject(), is(project));
         
    }
    
    @Test
    public void testBean() {
        assertThat(Question.class, allOf(
                hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanToString()
        ));
         
    }

}
