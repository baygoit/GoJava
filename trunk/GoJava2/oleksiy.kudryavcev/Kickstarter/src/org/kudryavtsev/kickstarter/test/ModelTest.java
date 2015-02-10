package org.kudryavtsev.kickstarter.test;

import org.junit.Test;
import org.kudryavtsev.kickstarter.data.Model;

public class ModelTest {
    Model model = new Model();

    @Test
    public void testModelInit() {
        model.init();
    }

    @Test
    public void testGetCategoriesList() {
        // assertEquals("",
        // model.getCategoriesList().toString());model.getCategoriesList()
        model.getCategoriesList();
    }

    @Test
    public void testGetProjectsList() {
        // assertEquals("", model.getProjectsList().toString());
        model.getProjectsList();
    }
}
