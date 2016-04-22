package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Reward;

@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class RewardDaoTest {

    @Autowired
    private RewardDao rewardDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void getAllForProjectTest() {
        Category category = new Category();
        categoryDao.add(category);
        Project project = new Project();
        project.setCategory(category);
        project.setName("testname");
        projectDao.add(project);
        Reward reward = new Reward();
        reward.setAmount(100);
        reward.setDescription("testdescription");
        reward.setProject(project);
        rewardDao.add(reward);
        rewardDao.getAllForProject(project);
        assertThat(project.getRewards().isEmpty(), is(false));
        for (Reward currentReward : project.getRewards()) {
            assertThat(currentReward.getAmount(), is(100));
            assertThat(currentReward.getDescription(), is("testdescription"));
        }
    }
}
