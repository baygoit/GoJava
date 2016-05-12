package ua.dborisenko.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class RewardTest {
    @PersistenceContext
    private EntityManager em;

    @Test
    public void mappingTest() {
        Category category = new Category();
        Project project = new Project();
        project.setCategory(category);
        Reward reward = new Reward();
        reward.setAmount(100);
        reward.setDescription("testdescription");
        reward.setProject(project);
        em.persist(category);
        em.persist(project);
        em.persist(reward);
        Query query = em.createQuery("FROM Reward");
        Reward resultReward = (Reward) query.getSingleResult();
        assertThat(resultReward.getDescription(), is("testdescription"));
        assertThat(resultReward.getAmount(), is(100));
    }
}
