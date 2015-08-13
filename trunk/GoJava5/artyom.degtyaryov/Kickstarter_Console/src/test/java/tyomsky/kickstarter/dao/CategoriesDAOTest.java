package tyomsky.kickstarter.dao;

import org.junit.Before;
import org.junit.Test;
import tyomsky.kickstarter.model.Category;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public abstract class CategoriesDAOTest {

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

    @Test
    public void WhenAdd_ShouldGetElement() throws Exception {
        Category category = new Category("name");
        categories.add(category);
        assertEquals(category, categories.get(0));
    }

    @Test
    public void WhenGetAll_ShouldReturnAllElements() {
        categories.getAll();
        Category category1 = new Category("name1");
        Category category2 = new Category("name2");
        Category category3 = new Category("name3");

        List<Category> expected = new ArrayList<>();
        expected.add(category1);
        expected.add(category2);
        expected.add(category3);

        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        assertArrayEquals(expected.toArray(), categories.getAll().toArray());
    }
}