package com.morkva.model.impl;

import com.morkva.entities.Category;
import com.morkva.entities.utils.ID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;

/**
 * Created by vladyslav on 07.05.15.
 */
public class CategoryRepositoryTest {

    public Category[] categories;

    CategoryRepository categoryRepository;

    @Before
    public void setUp() throws Exception {
        categories = new Category[] {
                new Category(3, "Name 3"),
                new Category(2, "Name 2"),
                new Category(1, "Name 1"),
                new Category(4, "Name 4")
        };
        categoryRepository = new CategoryRepository(categories);
    }

    @Test
    public void testGetByIndex() throws Exception {

        Category category = categoryRepository.getByIndex(0);
        Category category2 = categoryRepository.getByIndex(3);

        Assert.assertEquals(category.getName(), "Name 1");
        Assert.assertEquals(category2.getName(), "Name 4");
    }

    @Test
    public void testGetById() throws Exception {
        Category category = categoryRepository.getById(new ID(2));

        Assert.assertEquals(category.getId().getValue(), new ID(2).getValue());
    }

    @Test
    public void testAdd() throws Exception {
        Category categoryToAdd = new Category(5, "Name 5");
        categoryRepository.add(categoryToAdd);
        Category categoryToTest = categoryRepository.getById(new ID(5));
        Assert.assertEquals(categoryToTest.getName(), "Name 5");
    }
//
    @Test
    public void testRemove() throws Exception {
        categoryRepository.remove(categories[1]);
        Assert.assertEquals(categoryRepository.size(), 3);
    }

    @Test
    public void testUpdate() throws Exception {
        Category category = categories[0];
        category.setName("Name test");
        categoryRepository.update(category);
        Category category2 = categoryRepository.getById(category.getId());
        Assert.assertEquals(category2.getName(), "Name test");
    }


    @Test
    public void testSize() throws Exception {
        Assert.assertEquals(categoryRepository.size(), categories.length);
    }
}