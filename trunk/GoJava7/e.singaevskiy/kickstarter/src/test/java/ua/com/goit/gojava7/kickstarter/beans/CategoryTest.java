package ua.com.goit.gojava7.kickstarter.beans;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEqualsFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CategoryTest {
	
    @Test
    public void testConstructor() {
        
        String name = "name";
        Category category = new Category(1, name);
        
        assertThat(category.getName(), is(name));
         
    }
    
	@Test
    public void testBean() {
        assertThat(Category.class, allOf(
                hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanHashCodeFor("id"),
                hasValidBeanEqualsFor("id"),
                hasValidBeanToString()
        ));
         
    }
	
}
