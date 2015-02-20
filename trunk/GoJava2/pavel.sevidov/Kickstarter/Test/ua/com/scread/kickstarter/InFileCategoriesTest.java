package ua.com.scread.kickstarter;

import java.io.File;

import org.junit.After;

import ua.com.scread.kickstarter.storage.Categories;
import ua.com.scread.kickstarter.storage.InFileCategories;

public class InFileCategoriesTest extends CategotriesTest {

    @Override
    Categories getCategories() {
        return new InFileCategories("test-categories.txt");
    }
    
    @After
    public void cleanUp() {
        new File("test-categories.txt").delete();
    }

}
