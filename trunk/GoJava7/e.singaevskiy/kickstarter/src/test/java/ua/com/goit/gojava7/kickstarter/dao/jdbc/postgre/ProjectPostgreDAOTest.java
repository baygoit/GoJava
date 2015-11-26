package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.util.Utils;

public class ProjectPostgreDAOTest {

    List<Project> list;
    ProjectPostgreDAO dao;

    @Before
    public void setUp() throws Exception {
        Properties properties = Utils.readProperties("./src/test/resources/storages/db/config.properties");
        JdbcDispatcher dispatcher = new JdbcDispatcher(properties.getProperty("driver"), properties.getProperty("url"),
                properties.getProperty("user"), properties.getProperty("password"));

        list = new ArrayList<>();
        list.add(new Project(1, "p1", "a1", 0));
        list.add(new Project(2, "p2", "a2", 0));
        list.add(new Project(3, "p3", "a3", 0));
        dao = new ProjectPostgreDAO(dispatcher);
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

    @SuppressWarnings("unchecked")
    @Test
    public void testGoDespiteException() throws Exception {
        JdbcDispatcher dispatcher = Mockito.mock(JdbcDispatcher.class);
        Mockito.when(dispatcher.getConnection()).thenThrow(SQLException.class);
        dao = new ProjectPostgreDAO(dispatcher);
        dao.clear();
        dao.add(null);
        dao.addAll(list);
        dao.getAll();
        dao.get(0);
        dao.getByCategory(42);
        assertTrue(true);
    }
}
