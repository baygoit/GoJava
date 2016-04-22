package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;


@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectDaoTest {

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void getAllForCategoryTest() {
        Category category = new Category();
        categoryDao.add(category);
        Project project = new Project();
        project.setCategory(category);
        project.setName("testname");
        project.setDescription("testdescription");
        project.setHistory("testhistory");
        project.setVideoUrl("testvideourl");
        project.setDaysLeft(10);
        projectDao.add(project);
        projectDao.getAllForCategory(category);
        assertThat(category.getProjects().isEmpty(), is(false));
        for (Project currentProject : category.getProjects()) {
            assertThat(currentProject.getName(), is("testname"));
            assertThat(currentProject.getDescription(), is("testdescription"));
            assertThat(currentProject.getHistory(), is("testhistory"));
            assertThat(currentProject.getVideoUrl(), is("testvideourl"));
            assertThat(currentProject.getDaysLeft(), is(10));
        }
    }

    @Test
    public void getByIdTest() {
        Category category = new Category();
        categoryDao.add(category);
        Project project = new Project();
        project.setCategory(category);
        project.setName("testname");
        project.setDescription("testdescription");
        project.setHistory("testhistory");
        project.setVideoUrl("testvideourl");
        project.setDaysLeft(10);
        projectDao.add(project);
        projectDao.getById(1);
        assertThat(project.getName(), is("testname"));
        assertThat(project.getDescription(), is("testdescription"));
        assertThat(project.getHistory(), is("testhistory"));
        assertThat(project.getDaysLeft(), is(10));
    }
}
