package ua.dborisenko.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
public class RewardTest {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Test
    public void mappingTest() {
        try (Session session = sessionFactory.openSession()) {
            Category category = new Category();
            Project project = new Project();
            project.setCategory(category);
            Reward reward = new Reward();
            reward.setAmount(100);
            reward.setDescription("testdescription");
            reward.setProject(project);
            session.save(category);
            session.save(project);
            session.save(reward);
            session.flush();
        }
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM Reward");
            List<Reward> resultList = query.list();
            Reward resultReward = resultList.get(0);
            session.flush();
            assertThat(resultReward.getDescription(), is("testdescription"));
            assertThat(resultReward.getAmount(), is(100));
        }
    }
}
