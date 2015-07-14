package model;


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
}