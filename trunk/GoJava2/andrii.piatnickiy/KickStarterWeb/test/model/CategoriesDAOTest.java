package model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Test;

import controller.ConnectionToDB;

public class CategoriesDAOTest {
    ConnectionToDB connectToDB = new ConnectionToDB();
    Connection connection = connectToDB.getConnection(
            "jdbc:postgresql://127.0.0.1/kickstarter_test", "postgres", "pass");
    CategoriesDAO categoriesDAO = new CategoriesDAO(connection);

    @After
    public void closeConnection() throws SQLException {
        connection.close();
    }

    @Test
    public void shouldFirsCategory() throws SQLException {
        LinkedList<Category> categories = categoriesDAO.getCategoriesList();
        assertEquals("test_name_1", categories.get(0).getName());

    }

    @Test
    public void shouldLastCategory() throws SQLException {
        LinkedList<Category> categories = categoriesDAO.getCategoriesList();
        assertEquals("test_name_3", categories.get(categories.size() - 1).getName());
    }

}
