package com.sandarovich.kickstarter.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContextTest.xml"})

public class CategoryMappingTest {

    @PersistenceContext
    EntityManager em;

    private Category category;

    @Before
    public void init() {
        Category category1 = new Category();
        category1.setName("Cat1");
        Category category2 = new Category();
        category2.setName("Cat2");

        em.merge(category1);
        category = em.merge(category2);
    }

    @Test
    public void testCategoryMapping() {
        List<Category> categories = em.createNamedQuery("Category.getAll", Category.class).getResultList();
        assertThat(categories.get(0).getName(), is("Cat1"));
        assertThat(categories.get(0).getId(), is(1L));

        assertThat(categories.get(1).getName(), is("Cat2"));
        assertThat(categories.get(1).getId(), is(2L));

        Query query = em.createNamedQuery("Category.getById", Category.class);
        query.setParameter("id", this.category.getId());
        Category category = (Category) query.getSingleResult();
        assertThat(category.getId(), is(2L));
        assertThat(category.getName(), is("Cat2"));
    }

}
