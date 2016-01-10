package ua.com.goit.gojava7.kickstarter.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryTest{
    Category category = new Category();

    @Test
    public void testCategory() {
        assertNotNull(category);
    }

    @Test
    public void testSetGetCategoryId() {
        category.setCategoryId(1);
        assertThat(category.getCategoryId(), is(1));
    }

    @Test
    public void testSetGetCategoryName() {
        String categoryName = "Test";
        category.setCategoryName(categoryName);
        assertThat(category.getCategoryName(), is(categoryName));
    }

}
