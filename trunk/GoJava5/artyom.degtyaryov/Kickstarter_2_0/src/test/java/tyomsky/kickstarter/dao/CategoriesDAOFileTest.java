package tyomsky.kickstarter.dao;

import org.junit.After;

import java.io.File;

public class CategoriesDAOFileTest extends CategoriesTest {

    @After
    public void cleanUp() throws Exception {
        File file = new File("categories.txt");
        file.delete();
    }

    @Override
    public CategoriesDAO getCategoriesDAOImplementation() {
        return new CategoriesDAOFile("categories.txt");
    }
}