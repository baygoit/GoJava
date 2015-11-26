package model.storage;

import org.junit.Test;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.model.storage.InMemoryCategoryStorage;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InMemoryCategoryStorageTest {
    @Test
    public void test() {
        Category category0 = new Category("category0");
        Category category1 = new Category("category1");
        CategoryStorage storage = new InMemoryCategoryStorage();
        storage.add(category0);
        storage.add(category1);
        String name00 = "project00";
        Project project00 = new Project(name00,category0,null,null,null,null,100,10);
        String name01 = "project01";
        Project project01 = new Project(name01,category0,null,null,null,null,200,20);
        String name10 = "project10";
        Project project10 = new Project(name10,category1,null,null,null,null,300,30);
        String name11 = "project11";
        Project project11 = new Project(name11,category1,null,null,null,null,400,40);
        category0.add(project00);
        category0.add(project01);
        category1.add(project10);
        category1.add(project11);
        List<Category> categories = storage.getCategories();
        int n = categories.size();
        List<Project> projects0 = categories.get(n - 2).getProjects();
        List<Project> projects1 = categories.get(n - 1).getProjects();
        assertThat(projects0.get(0).getName(),is(name00));
        assertThat(projects0.get(1).getName(),is(name01));
        assertThat(projects1.get(0).getName(),is(name10));
        assertThat(projects1.get(1).getName(),is(name11));

    }
}
