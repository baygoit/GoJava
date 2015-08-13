package tyomsky.kickstarter.dao;

import org.junit.After;
import org.junit.Before;
import tyomsky.kickstarter.common.DBConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoriesDAODBTest extends CategoriesDAOTest{

    @Before
    public void initializeDB() {
        try (Connection connection = new DBConnector("conf/h2db.properties").getConnection()) {
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
        try (Connection connection = new DBConnector("conf/h2db.properties").getConnection()) {
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