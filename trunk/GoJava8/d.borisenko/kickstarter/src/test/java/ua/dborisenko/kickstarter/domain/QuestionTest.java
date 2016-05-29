package ua.dborisenko.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
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
public class QuestionTest {
    @PersistenceContext
    private EntityManager em;

    @Test
    public void mappingTest() {
        Category category = new Category();
        Project project = new Project();
        project.setCategory(category);
        Question question = new Question();
        question.setRequest("testrequest");
        question.setReply("testreply");
        question.setProject(project);
        em.persist(category);
        em.persist(project);
        em.persist(question);
        em.clear();
        int id = question.getId();
        Question resultQuestion = em.find(Question.class, id);
        assertThat(resultQuestion.getRequest(), is("testrequest"));
        assertThat(resultQuestion.getReply(), is("testreply"));
        assertThat(resultQuestion.getProject(), is(notNullValue()));
    }
}
