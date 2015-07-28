package tyomsky.kickstarter.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class CategoriesDAODBTest extends CategoriesDAOTest{

    @Before
    public void initializeDB() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:kickstarter;DB_CLOSE_DELAY=-1", "sa", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Categories (" +
                    " id INT PRIMARY KEY AUTO_INCREMENT," +
                    " name VARCHAR(255) )");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @After
    public void CleanUp() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:kickstarter;DB_CLOSE_DELAY=-1", "sa", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Categories");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CategoriesDAO getCategoriesDAOImplementation() {
        return new CategoriesDAODB();
    }
}