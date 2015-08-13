package tyomsky.kickstarter.dao;

import org.junit.After;

import java.io.File;
import java.net.URL;

public class CategoriesDAOFileTest extends CategoriesDAOTest {

    @After
    public void cleanUp() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String fileName = "file/categoriesTest.txt";
        URL fileURL = classLoader.getResource(fileName);
        if (fileURL == null) {
            throw new RuntimeException(String.format("file %s, does not exists", fileName));
        }
        File file = new File(fileURL.getFile());
        file.delete();
        file.createNewFile();
    }

    @Override
    public CategoriesDAO getCategoriesDAOImplementation() {
//        File file = new File("categoriesTest.txt");
        return new CategoriesDAOFile("file/categoriesTest.txt");
    }
}