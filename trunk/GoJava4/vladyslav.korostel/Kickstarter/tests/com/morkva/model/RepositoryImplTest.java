package com.morkva.model;

import com.morkva.entities.Category;
import com.morkva.entities.Quote;
import com.morkva.model.impl.RepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vladyslav on 11.05.15.
 */
public class RepositoryImplTest {

    Repository<Category> categoryRepository;
    Repository<Quote> quoteRepository;

    @Before
    public void setUp() {
        categoryRepository = new RepositoryImpl<>();
        quoteRepository = new RepositoryImpl<>();
    }

    @Test
    public void shouldNonEmpty_WhenAdd() {
        categoryRepository.add(new Category(1, "Name 1"));
        Assert.assertEquals(1, categoryRepository.size());
    }

    @Test
    public void shouldNotAdd_WhenExist() {
        categoryRepository.add(new Category(1, "Name 1"));
        boolean added = categoryRepository.add(new Category(1, "Name 1"));
        Assert.assertFalse(added);
        Assert.assertEquals(1, categoryRepository.size());
    }

    @Test
    public void shouldNotRemove_WhenEmpty() {
        boolean removed = categoryRepository.remove(new Category(1, "Name 1"));
        Assert.assertFalse(removed);
    }

    @Test
    public void shouldNotRemove_WhenNotExist() {
        categoryRepository.add(new Category(1, "Name 1"));
        categoryRepository.add(new Category(2, "Name 2"));
        boolean removed = categoryRepository.remove(new Category(3, "Name 3"));
        Assert.assertFalse(removed);
    }

    @Test
    public void shouldRemove_WhenExist() {
        Category category1 = new Category(1, "Name 1");
        categoryRepository.add(category1);
        Category category2 = new Category(2, "Name 2");
        categoryRepository.add(category2);
        Assert.assertEquals(2, categoryRepository.size());

        boolean removed = categoryRepository.remove(category2);

        Assert.assertTrue(removed);
        Assert.assertEquals(1, categoryRepository.size());
    }

    @Test
    public void shouldNotUpdate_WhenEmpty() {
        boolean updated = categoryRepository.update(new Category(1, "Name 2"));
        Assert.assertFalse(updated);
    }

    @Test
    public void shouldNotUpdate_WhenNotExist() {
        Category category1 = new Category(1, "Name 1");
        Category category2 = new Category(2, "Name 2");
        categoryRepository.add(category1);
        categoryRepository.add(category2);
        Assert.assertEquals(2, categoryRepository.size());

        Category category3 = new Category(3, "Name 3");
        boolean updated = categoryRepository.update(category3);
        Assert.assertFalse(updated);
    }

    @Test
    public void shouldUpdate_WhenExist() {
        Category category1 = new Category(1, "Name 1");
        Category category2 = new Category(2, "Name 2");
        categoryRepository.add(category1);
        categoryRepository.add(category2);
        Assert.assertEquals(2, categoryRepository.size());

        category2.setName("New Name 2");
        boolean updated = categoryRepository.update(category2);
        Assert.assertTrue(updated);
        Assert.assertEquals("New Name 2", categoryRepository.getById(2).getName());
    }

    @Test
    public void shouldNull_WhenEmpty() throws Exception {
        Category category = categoryRepository.getByIndex(0);
        Category category2 = categoryRepository.getById(0);

        Assert.assertNull(category);
        Assert.assertNull(category2);
    }

    @Test
    public void shouldNotNull_WhenNotEmpty() throws Exception {
        categoryRepository.add(new Category(1, "Name 1"));
        Category category = categoryRepository.getByIndex(0);
        Category category2 = categoryRepository.getById(1);

        Assert.assertNotNull(category);
        Assert.assertEquals("Name 1", category.getName());

        Assert.assertNotNull(category2);
        Assert.assertEquals("Name 1", category2.getName());
    }

    @Test
    public void shouldNotEmpty_WhenCreatedWithParams() {
        Category[] categories = new Category[] {
                new Category(1, "Name 1"),
                new Category(3, "Name 3"),
                new Category(2, "Name 2")
        };
        categoryRepository = new RepositoryImpl<>(categories);
        int size = categoryRepository.size();
        Assert.assertEquals(3, size);
    }
}