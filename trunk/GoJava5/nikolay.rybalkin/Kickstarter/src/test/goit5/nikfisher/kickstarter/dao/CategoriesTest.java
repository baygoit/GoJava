package goit5.nikfisher.kickstarter.dao;

import goit5.nikfisher.kickstarter.model.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("deprecation")
public abstract class CategoriesTest {

    private Categories categories;

    @Before
    public void setup() {
        categories = getCategories();
    }

    abstract Categories getCategories();

    @Test
    public void shouldCategoriesWenAddCategories() {
        //given
        //when
        categories.add(new Category("Game"));
        categories.add(new Category("Design"));

        //then
        assertEquals("[1) Game, 2) Design]", String.valueOf(categories.getCategories()));
    }

    @Test
    public void shouldCategoriesWenNoCategories() {
        //given
        //when
        //then
        assertEquals("[]", String.valueOf(categories.getCategories()));
    }

    @Test
    public void shouldCategoriesIndex() {
        //given
        Category category1 = new Category("Game");
        categories.add(category1);

        Category category2 = new Category("Design");
        categories.add(category2);

        //when
        //then
        assertEquals(category1, categories.get(0));
        assertEquals(category2, categories.get(1));
    }

    @Test
    public void shouldCategoriesSizeWhenNoCategories() {
        //then
        assertEquals(0, categories.size());
    }

    @Test
    public void shouldCategoriesSize() {
        //given

        //when
        categories.add(new Category("Game"));
        categories.add(new Category("Design"));

        //then
        assertEquals(2, categories.size());
    }
}