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

public class AwardMappingTest {

    @PersistenceContext
    EntityManager em;
    private Project project;

    @Before
    public void init() {
        project = new Project();
        em.persist(project);

        Award award1 = new Award();
        award1.setDescription("AW1_Description");
        award1.setAmount(1);
        award1.setName("AW1");
        award1.setProject(project);

        Award award2 = new Award();
        award2.setDescription("AW2_Description");
        award2.setAmount(100);
        award2.setName("AW2");
        award2.setProject(project);

        em.merge(award1);
        em.merge(award2);
    }

    @Test
    public void testAwardMapping() {
        Query query = em.createNamedQuery("Award.getByProject", Award.class);
        query.setParameter("project", project);
        List<Award> awards = query.getResultList();
        assertThat(awards.get(0).getId(), is(1L));
        assertThat(awards.get(0).getDescription(), is("AW1_Description"));
        assertThat(awards.get(0).getAmount(), is(1.0));
        assertThat(awards.get(0).getName(), is("AW1"));
        assertThat(awards.get(0).getProject(), is(project));

        assertThat(awards.get(1).getId(), is(2L));
        assertThat(awards.get(1).getDescription(), is("AW2_Description"));
        assertThat(awards.get(1).getAmount(), is(100.0));
        assertThat(awards.get(1).getName(), is("AW2"));
        assertThat(awards.get(1).getProject(), is(project));
    }


}
