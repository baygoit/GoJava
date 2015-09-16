package com.tyomsky.kickstarter.service.impl;

import com.tyomsky.kickstarter.dao.CategoryDAO;
import com.tyomsky.kickstarter.domain.Category;
import com.tyomsky.kickstarter.service.impl.CategoryServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CategoryServiceTest {

    @Mock
    CategoryDAO categoryDAO;

    @InjectMocks
    CategoryServiceImpl categoryService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenGetCategoryById_ThenReturnCategory() throws Exception {
        Category expectedCategory = new Category();
        expectedCategory.setId(1);
        expectedCategory.setName("name");

        when(categoryDAO.get(1)).thenReturn(expectedCategory);

        Category actualCategory = categoryService.getCategoryById(1);
        verify(categoryDAO, times(1)).get(1);
        assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void whenGetAllCategories_ThenReturnAllCategories() throws Exception {
        Category category1 = new Category();
        category1.setId(1);
        category1.setName("category1");

        Category category2 = new Category();
        category2.setId(2);
        category2.setName("category2");

        List<Category> expectedCategories = Arrays.asList(category1, category2);

        when(categoryDAO.getAll()).thenReturn(expectedCategories);

        List<Category> actualCategories = categoryService.getAllCategories();

        verify(categoryDAO, times(1)).getAll();

        assertArrayEquals(expectedCategories.toArray(), actualCategories.toArray());
    }

}