package ua.com.goit.gojava7.kickstarter.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;

public class CategoryTest{
    private Category category = new Category();
    private List<Project> projects = new ArrayList<>();
    @Test
    public void testSetProjects() {
       category.setProjects(projects);
       assertThat(category.getProjects(), is(projects));
    }

    @Test
    public void testCategoryStringInt() {
        final String categoryName = "test1";
        final int categoryId = 12345;
        Category category2 = new Category(categoryName, categoryId);
        assertThat(category2.getCategoryName().equals(categoryName),is(true));
        assertThat(category2.getCategoryId(),is(categoryId));
        
    }

    @Test
    public void testSetCategoryId() {
        category.setCategoryId(1230);
        assertThat(category.getCategoryId(),is(1230));
    }

    @Test
    public void testSetCategoryName() {
       final String categoryName = "name";
    category.setCategoryName(categoryName);
       assertThat(category.getCategoryName().equals(categoryName),is(true));
    }

}
