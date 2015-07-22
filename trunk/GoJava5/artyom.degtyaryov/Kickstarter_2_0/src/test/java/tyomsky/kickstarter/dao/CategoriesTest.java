package tyomsky.kickstarter.dao;

import org.junit.Before;
import org.junit.Test;
import tyomsky.kickstarter.dao.CategoriesDAO;
import tyomsky.kickstarter.model.Category;

import static org.junit.Assert.*;

public abstract class CategoriesTest {

    private CategoriesDAO categories;

    @Before
    public void setUp() throws Exception {
        categories = getCategoriesDAOImplementation();
    }

    public abstract CategoriesDAO getCategoriesDAOImplementation();

    @Test
    public void WhenSize_ShouldReturnCountOfElements() throws Exception {
        categories.add(new Category("category"));
        assertEquals(1, categories.size());
        categories.add(new Category("category1"));
        assertEquals(2, categories.size());
    }

    @Test
    public void WhenSizeWithNoElements_ShouldReturnZero() throws Exception {
        assertEquals(0, categories.size());
    }

    @Test
    public void WhenGet_ShouldReturnElement() throws Exception {
        Category category = new Category("name1");
        categories.add(category);
        assertEquals(category, categories.get(0));
    }

    @Test
    public void WhenAdd_ShouldSizeIncrement() throws Exception {
        int sizeBefore = categories.size();
        categories.add(new Category("category"));
        int sizeAfter = sizeBefore + 1;
        assertEquals(sizeAfter, categories.size());
    }

    public void WhenAdd_ShouldGetElement() throws Exception {
        Category category = new Category("name");
        categories.add(category);
        assertEquals(category, categories.get(0));
    }
}