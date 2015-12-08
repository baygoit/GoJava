package ua.com.goit.gojava7.salivon.stores;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import ua.com.goit.gojava7.salivon.beans.Category;

public class StoreCategoriesTest {

    @Test
    public void testGetCategories() {
        List<Category> result = StoreCategories.getCategories();
        assertTrue(result instanceof List);
    }

}
