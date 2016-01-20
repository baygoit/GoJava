package ua.com.goit.gojava7.kickstarter.datasource.implementation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.goit.gojava7.kickstarter.datasource.IntegrationTest;
import ua.com.goit.gojava7.kickstarter.datasource.implementation.ProjectPostgreDAO;
import ua.com.goit.gojava7.kickstarter.datasource.implementation.RewardPostgreDAO;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext*.xml")
public class RewardPostgreDAOTest  implements IntegrationTest{

    List<Reward> list;
    
    @Autowired
    RewardPostgreDAO rewardPostgreDAO;
    
    @Autowired
    ProjectPostgreDAO projectPostgreDAO;

	private List<Project> projects;

    @Before
    public void setUp() throws Exception {
    	projects = projectPostgreDAO.getAll();
    	
    	rewardPostgreDAO.clear();
        list = new ArrayList<>();
        list.add(new Reward(projects.get(0), "r1", 113));
        list.add(new Reward(projects.get(0), "r2", 44));
        list.add(new Reward(projects.get(1), "r3", 33));
    }

    @Test
    public void testAddGetAll() {
    	rewardPostgreDAO.addAll(list);
        assertThat(rewardPostgreDAO.getAll(), is(list));
    }
    
    @Test
    public void testAddGet() {
        list.forEach(rewardPostgreDAO::add);
        Reward reward = list.get(1);
        Long index = reward.getId();
        assertThat(rewardPostgreDAO.get(index), is(reward));
    }
    
    @Test
    public void testGetByProject() {
    	rewardPostgreDAO.addAll(list);
    	Long id = projects.get(0).getId();
        rewardPostgreDAO.getByProject(id).forEach(p -> assertThat(p.getProject().getId(), is(id)));
    }

}
