package model;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Test;

import controller.ConnectionToDB;

public class ProjectsDAOTests {
    ConnectionToDB connectToDB = new ConnectionToDB();
    Connection connection = connectToDB.getConnection(
            "jdbc:postgresql://127.0.0.1/kickstarter_test", "postgres", "pass");
    ProjectsDAO projectsDAO = new ProjectsDAO(connection);

    @After
    public void closeConnection() throws SQLException {
        connection.close();
    }
    
    @Test
    public void shouldFirsProject_WhenCategoryId1() throws SQLException {
        LinkedList<Project> projects = projectsDAO.getProjectsList(1);
        assertEquals("Bicycle_test", projects.get(0).getName());
    }

    @Test
    public void shouldLastProject_WhenCategoryId1() throws SQLException {
        LinkedList<Project> projects = projectsDAO.getProjectsList(1);
        assertEquals("Snowboard_test", projects.get(projects.size() - 1).getName());
    }
    
    @Test
    public void shouldFirsProject_WhenCategoryId2() throws SQLException {
        LinkedList<Project> projects = projectsDAO.getProjectsList(2);
        assertEquals("BMW X3_test", projects.get(0).getName());
    }

    @Test
    public void shouldLastProject_WhenCategoryId2() throws SQLException {
        LinkedList<Project> projects = projectsDAO.getProjectsList(2);
        assertEquals("Audi Q5_test", projects.get(projects.size() - 1).getName());
    }
}
