package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectPostgreDAOTest {

    List<Project> list;
    ProjectPostgreDAO dao;

    @Before
    public void setUp() throws Exception {
        dao = new ProjectPostgreDAO();
		dao.setJdbcTemplate(TestDaoFactory.setupJdbcTemplate()); 

        list = new ArrayList<>();
        list.add(new Project(1, "p1", "a1", 0));
        list.add(new Project(2, "p2", "a2", 0));
        list.add(new Project(3, "p3", "a3", 0));
    }

    @After
    public void tearDown() throws Exception {
        dao.clear();
    }

    @Test
    public void testAddGetAll() {
        dao.addAll(list);
        assertThat(dao.getAll(), is(list));
    }

    @Test
    public void testAddGet() {
        Project project = list.get(1);
        list.forEach(dao::add);
        assertThat(dao.get(project.getId()), is(project));
    }

    @Test
    public void testGetByCategory() {
        dao.addAll(list);
        int catId = 1;
        dao.getByCategory(1).forEach(p -> assertThat(p.getCategoryId(), is(catId)));
    }

}
