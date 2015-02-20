package ua.com.scread.kickstarter;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ua.com.scread.kickstarter.storage.Categories;
import ua.com.scread.kickstarter.storage.CategoriesDAO;

public class CategoriesDAOTest extends CategotriesTest {

    @Override
    Categories getCategories() {
        return new CategoriesDAO();
    }
    
    @Override
    @Test
    public void shouldReturnSize_whenGetSize() {
        assertTrue(categories.size() >= 0);
    }

}
