package ua.dborisenko.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
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
public class ProjectTest {
    @PersistenceContext
    private EntityManager em;

    @Test
    public void mappingTest() {
        Category category = new Category();
        Project project = new Project();
        project.setName("testname");
        project.setDescription("testdescription");
        project.setHistory("testhistory");
        project.setVideoUrl("testvideourl");
        project.setRemainingDays(10);
        project.setRequiredSum(100);
        project.setCategory(category);
        Investment investment = new Investment();
        investment.setProject(project);
        investment.setAmount(42);
        Reward reward = new Reward();
        reward.setProject(project);
        Question question = new Question();
        question.setProject(project);
        em.persist(category);
        em.persist(project);
        em.persist(investment);
        em.persist(reward);
        em.persist(question);
        em.clear();
        int id = project.getId();
        Project resultProject = em.find(Project.class, id);
        assertThat(resultProject.getName(), is("testname"));
        assertThat(resultProject.getDescription(), is("testdescription"));
        assertThat(resultProject.getHistory(), is("testhistory"));
        assertThat(resultProject.getVideoUrl(), is("testvideourl"));
        assertThat(resultProject.getRemainingDays(), is(10));
        assertThat(resultProject.getRequiredSum(), is(100));
        assertThat(resultProject.getCategory(), is(notNullValue()));
        assertThat(resultProject.getInvestments().size(), is(1));
        assertThat(resultProject.getCollectedSum(), is(42));
        assertThat(resultProject.getRewards().size(), is(1));
        assertThat(resultProject.getQuestions().size(), is(1));
    }
}
