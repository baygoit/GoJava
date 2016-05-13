package ua.dborisenko.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CategoryTest {
    @PersistenceContext
    private EntityManager em;

    @Test
    public void mappingTest() {
        Category category = new Category();
        category.setName("testname");
        Project project = new Project();
        project.setCategory(category);
        em.persist(category);
        em.persist(project);
        em.clear();
        int id = category.getId();
        Category resultCategory = em.find(Category.class, id);
        assertThat(resultCategory.getName(), is("testname"));
        assertThat(resultCategory.getProjects().size(), is(1));
    }
}
