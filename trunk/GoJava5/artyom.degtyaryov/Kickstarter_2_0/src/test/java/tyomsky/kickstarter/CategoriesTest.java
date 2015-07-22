package tyomsky.kickstarter;

import org.junit.Test;

import static org.junit.Assert.*;

public abstract class CategoriesTest {

    public abstract Categories getCategoriesImplementation();

    @Test
    public void WhenSize_ShouldReturnCountOfElements() throws Exception {
        Categories categories = getCategoriesImplementation();
        categories.add(new Category("category"));
        assertEquals(1, categories.size());
        categories.add(new Category("category1"));
        assertEquals(2, categories.size());
    }

    @Test
    public void WhenSizeWithNoElements_ShouldReturnZero() throws Exception {
        Categories categories = getCategoriesImplementation();
        assertEquals(0, categories.size());
    }

    @Test
    public void WhenGet_ShouldReturnElement() throws Exception {
        Categories categories = getCategoriesImplementation();
        Category category = new Category("name1");
        categories.add(category);
        assertEquals(category, categories.get(0));
    }

    @Test
    public void WhenAdd_ShouldSizeIncrement() throws Exception {
        Categories categories = getCategoriesImplementation();
        int sizeBefore = categories.size();
        categories.add(new Category("category"));
        int sizeAfter = sizeBefore + 1;
        assertEquals(sizeAfter, categories.size());
    }

    public void WhenAdd_ShouldGetElement() throws Exception {
        Categories categories = getCategoriesImplementation();
        Category category = new Category("name");
        categories.add(category);
        assertEquals(category, categories.get(0));
    }
}