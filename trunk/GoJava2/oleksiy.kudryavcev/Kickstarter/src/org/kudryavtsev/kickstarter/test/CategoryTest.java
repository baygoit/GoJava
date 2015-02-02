package org.kudryavtsev.kickstarter.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.kudryavtsev.kickstarter.data.Category;
import org.kudryavtsev.kickstarter.data.Project;

public class CategoryTest {

    @Test
    public void shouldBeCertainString_whenNewCertainCategory() {
        String expected = "Movies - Movies category";
        Category category = new Category("Movies", "Movies category");
        categoryCheck(expected, category);
    }

    @Test
    public void shouldBeDefault_whenNewDefaultnCategory() {
        String expected = "Other - For other projects";
        Category category = new Category();
        categoryCheck(expected, category);
    }

    private void categoryCheck(String expected, Category category) {
        String actual;
        actual = category.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnProjectToString_whenSetProjectsList() {
        List<Project> projectsList = new ArrayList<Project>();
        projectsList.add(new Project("TestProject", "TestDescption", 100, 100, 100));
        Category category = new Category();
        category.setProjectsList(projectsList);
        assertEquals("TestProject; TestDescption; funded: 100; pledged: 100; days to go: 100",
                category.getProjectsList().get(0).toString());
    }

}
