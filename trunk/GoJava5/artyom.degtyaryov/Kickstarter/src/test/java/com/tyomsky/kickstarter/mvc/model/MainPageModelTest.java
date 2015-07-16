package com.tyomsky.kickstarter.mvc.model;

import com.tyomsky.kickstarter.dao.DataRegistry;
import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.model.Project;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class MainPageModelTest {

    @Mock
    DataRegistry dataProvider;

    @InjectMocks
    MainPageModel model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenUpdateThenGetQuote() throws Exception {
        when(dataProvider.getSomeQuote()).thenReturn("some quote");

        model.update();

        String actual = model.getQuote();
        assertEquals("some quote", actual);
    }

    @Test
    public void whenUpdateThenGetCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("cat1", new ArrayList<Project>()));
        categories.add(new Category("cat2", new ArrayList<Project>()));

        when(dataProvider.getCategoriesList()).thenReturn(categories);

        model.update();

        List<Category> actual = model.getCategories();

        assertEquals(categories, actual);
    }
}