package com.sandarovich.kickstarter.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContextTest.xml"})

public class ProjectMappingTest {

    @PersistenceContext
    private EntityManager em;
    private Category category1;
    private Category category2;

    @Before
    public void init() {
        category1 = new Category();
        category1.setName("1");
        category2 = new Category();
        category2.setName("2");
        em.merge(category1);
        em.merge(category2);


        Project project1 = new Project();
        project1.setCategory(category1);
        project1.setName("Project1");
        project1.setDescription("Description1");
        project1.setDaysLeft(1);
        project1.setHistory("1h");
        project1.setVideoLink("url1");
        project1.setRequiredBudget(123.0);

        Project project2 = new Project();
        project2.setCategory(category2);
        project2.setName("Project2");
        project2.setDescription("Description2");
        project2.setDaysLeft(2);
        project2.setHistory("2h");
        project2.setVideoLink("url2");
        project2.setRequiredBudget(923.0);

        em.merge(project1);
        em.merge(project2);
    }

    @Test
    public void testProjectMapping() {
        List<Project> projects = em.createQuery("From Project").getResultList();

        assertThat(projects.get(0).getName(), is("Project1"));
        assertThat(projects.get(0).getDescription(), is("Description1"));
        assertThat(projects.get(0).getDaysLeft(), is(1));
        assertThat(projects.get(0).getHistory(), is("1h"));
        assertThat(projects.get(0).getVideoLink(), is("url1"));
        assertThat(projects.get(0).getRequiredBudget(), is(123.0));
        assertThat(projects.get(0).getCategory().getName(), is("1"));

        assertThat(projects.get(1).getName(), is("Project2"));
        assertThat(projects.get(1).getDescription(), is("Description2"));
        assertThat(projects.get(1).getDaysLeft(), is(2));
        assertThat(projects.get(1).getHistory(), is("2h"));
        assertThat(projects.get(1).getVideoLink(), is("url2"));
        assertThat(projects.get(1).getRequiredBudget(), is(923.0));
        assertThat(projects.get(1).getCategory().getName(), is("2"));
    }
}
