package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;

@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryDaoTest {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProjectDao projectDao;

    @Before
    public void setUp() {

    }

    @Test
    public void getByIdTest() {
        Category category = new Category();
        category.setName("testname");
        categoryDao.add(category);
        categoryDao.getById(1);
        assertThat(category.getName(), is("testname"));
    }

    @Test
    public void getAllTest() {
        Category category1 = new Category();
        categoryDao.add(category1);
        Category category2 = new Category();
        categoryDao.add(category2);
        List<Category> categories = categoryDao.getAll();
        assertThat(categories.size(), is(greaterThan(2)));
    }

    @Test
    public void getByProjectIdTest() {
        Category category = new Category();
        category.setName("testname");
        categoryDao.add(category);
        Project project = new Project();
        project.setCategory(category);
        projectDao.add(project);
        assertThat(categoryDao.getByProject(project).getName(), is("testname"));
    }
}
