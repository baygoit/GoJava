package tyomsky.kickstarter.dao;

import org.junit.After;

import java.io.File;

public class CategoriesDAOFileTest extends CategoriesDAOTest {

    @After
    public void cleanUp() throws Exception {
        File file = new File("categoriesTest.txt");
        file.delete();
    }

    @Override
    public CategoriesDAO getCategoriesDAOImplementation() {
        return new CategoriesDAOFile("categoriesTest.txt");
    }
}