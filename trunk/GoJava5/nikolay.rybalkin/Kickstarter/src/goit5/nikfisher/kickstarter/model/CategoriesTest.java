package goit5.nikfisher.kickstarter.model;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CategoriesTest {

    @Test
    public void shouldCategoriesListWenAddCategories() throws Exception {
        //given
        Categories list = new Categories();

        //when
        list.add(new Category("name1"));
        list.add(new Category("name2"));

        //then
        assertEquals("[1) name1, 2) name2]", Arrays.toString(list.getCategories()));
    }

    @Test
    public void shouldCategoriesListWenNoCategories() throws Exception {
        //given
        Categories list = new Categories();

        //when
        list.add(new Category("name1"));
        list.add(new Category("name2"));

        //then
        assertEquals("[]", Arrays.toString(list.getCategories()));
    }

    @Test
    public void shouldCategoriesIndex() throws Exception {
        //given
        Categories list = new Categories();

        //when
        Category category1 = new Category("name1");
        list.add(category1);
        Category category2 = new Category("name2");
        list.add(category2);

        //then
        assertEquals(category1, list.get(0));
        assertEquals(category2, list.get(1));
    }
}