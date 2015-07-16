package com.tyomsky.kickstarter.mvc.model;

import com.tyomsky.kickstarter.dao.DataRegistry;
import com.tyomsky.kickstarter.model.Category;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CategoryPageModelTest {

    @Mock
    DataRegistry dataProvider;

    @Mock
    Category category;

    @InjectMocks
    CategoryPageModel model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenUpdateThenReturnCategory() {
        int categoryIndex = 1;
        when(dataProvider.getCategoryById(categoryIndex)).thenReturn(category);

        Category expected = category;
        model.update(categoryIndex);
        Category actual = model.getCategory();
        assertEquals(expected,actual);
    }

}