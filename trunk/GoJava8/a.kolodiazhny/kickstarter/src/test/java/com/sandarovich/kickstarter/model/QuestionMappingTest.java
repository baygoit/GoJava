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
import javax.persistence.TypedQuery;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContextTest.xml"})

public class QuestionMappingTest {

    @PersistenceContext
    EntityManager em;
    private Project project;

    @Before
    public void init() {
        project = new Project();
        project.setName("project");

        em.persist(project);

        Question question1 = new Question();
        question1.setText("Q1");
        question1.setProject(project);

        Question question2 = new Question();
        question2.setText("Q2");
        question2.setProject(project);

        em.merge(question1);
        em.merge(question2);
    }

    @Test
    public void testQuestionMapping() {
        TypedQuery<Question> query = em.createNamedQuery("Question.getQuestions", Question.class);
        query.setParameter("project", project);
        List<Question> questions = query.getResultList();

        assertThat(questions.get(0).getText(), is("Q1"));
        assertThat(questions.get(1).getText(), is("Q2"));

    }

}
