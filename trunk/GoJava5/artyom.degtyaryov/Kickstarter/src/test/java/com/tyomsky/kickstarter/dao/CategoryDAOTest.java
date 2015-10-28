package com.tyomsky.kickstarter.dao;

import com.tyomsky.kickstarter.domain.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:spring-test-config/application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryDAOTest {

    @Autowired
    CategoryDAO categoryDAO;

    @Test
    @Transactional
    @Rollback
    public void testSave() throws Exception {
        Category category1 = new Category("category1");
        Category category2 = new Category("category2");
        Category category3 = new Category("category3");

        categoryDAO.save(category1);
        categoryDAO.save(category2);
        categoryDAO.save(category3);

        assertEquals(category1.getName(), categoryDAO.get(category1.getId()).getName());
        assertEquals(category2.getName(), categoryDAO.get(category2.getId()).getName());
        assertEquals(category3.getName(), categoryDAO.get(category3.getId()).getName());
    }

    @Test
    @Transactional
    @Rollback
    public void testGet() throws Exception {
        Category category1 = new Category("category1");
        Category category2 = new Category("category2");
        Category category3 = new Category("category3");

        categoryDAO.save(category1);
        categoryDAO.save(category2);
        categoryDAO.save(category3);

        assertEquals(category1.getName(), categoryDAO.get(category1.getId()).getName());
        assertEquals(category2.getName(), categoryDAO.get(category2.getId()).getName());
        assertEquals(category3.getName(), categoryDAO.get(category3.getId()).getName());
    }

    @Test
    @Transactional
    @Rollback
    public void testGetAll() throws Exception {
        Category category1 = new Category("category1");
        Category category2 = new Category("category2");
        Category category3 = new Category("category3");

        categoryDAO.save(category1);
        categoryDAO.save(category2);
        categoryDAO.save(category3);

        List<Category> categories = categoryDAO.getAll();

        assertTrue(categories.contains(category1));
        assertTrue(categories.contains(category2));
        assertTrue(categories.contains(category3));
    }
}