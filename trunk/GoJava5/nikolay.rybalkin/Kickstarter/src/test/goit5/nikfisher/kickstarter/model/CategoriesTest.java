package goit5.nikfisher.kickstarter.model;

import goit5.nikfisher.kickstarter.dao.Categories;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import static org.junit.Assert.*;

public abstract class CategoriesTest {

    private Categories categories;

    @Before
    public void setup(){
        categories = getCategories();
    }

    abstract Categories getCategories();

    @Test
    public void shouldCategoriesWenAddCategories() throws Exception {
        //given
        //when
        categories.add(new Category("Game"));
        categories.add(new Category("Design"));

        //then
        assertEquals("[1) Game, 2) Design]", Arrays.toString(categories.getCategories()));
    }

    @Test
    public void shouldCategoriesWenNoCategories() throws Exception {
        //given
        //when
        //then
        assertEquals("[]", Arrays.toString(categories.getCategories()));
    }

    @Test
    public void shouldCategoriesIndex() throws Exception {
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
    public void shouldCategoriesSizeWhenNoCategories() throws Exception {
        //then
        assertEquals(0, categories.size());
    }

    @Test
    public void shouldCategoriesSize() throws Exception {
        //given
        new File("categories_test.txt").delete();

        //when
        categories.add(new Category("Game"));
        categories.add(new Category("Design"));

        //then
        assertEquals(2, categories.size());
    }
}