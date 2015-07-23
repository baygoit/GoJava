package goit5.nikfisher.kickstarter.model;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CategoriesTest {

    @Test
    public void shouldCategoriesWenAddCategories() throws Exception {
        //given
        Categories categories = new Categories();

        //when
        categories.add(new Category("Game"));
        categories.add(new Category("Design"));

        //then
        assertEquals("[1) Game, 2) Design]", Arrays.toString(categories.getCategories()));
    }

    @Test
    public void shouldCategoriesWenNoCategories() throws Exception {
        //given
        Categories categories = new Categories();

        //when

        //then
        assertEquals("[]", Arrays.toString(categories.getCategories()));
    }

    @Test
    public void shouldCategoriesIndex() throws Exception {
        //given
        Categories categories = new Categories();

        //when
        Category category1 = new Category("name1");
        categories.add(category1);
        Category category2 = new Category("name2");
        categories.add(category2);

        //then
        assertEquals(category1, categories.get(0));
        assertEquals(category2, categories.get(1));
    }

    @Test
    public void shouldCategoriesSize() throws Exception {
        //given
        Categories categories = new Categories();
        assertEquals(0, categories.size());

        //when
        categories.add(new Category("Game"));
        categories.add(new Category("Design"));

        //then
        assertEquals(2, categories.size());
    }
}