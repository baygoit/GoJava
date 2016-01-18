package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

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

import ua.com.goit.gojava7.kickstarter.dao.IntegrationTest;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.ProjectPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.RewardPostgreDAO;
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
        list.add(new Reward(1, projects.get(0), "r1", 113));
        list.add(new Reward(2, projects.get(0), "r2", 44));
        list.add(new Reward(3, projects.get(1), "r3", 33));
        rewardPostgreDAO.addAll(list);
    }

    @Test
    public void testAddGetAll() {
        assertThat(rewardPostgreDAO.getAll(), is(list));
    }
    
    @Test
    public void testAddGet() {
    	rewardPostgreDAO.clear();
        list.forEach(rewardPostgreDAO::add);
        Reward reward = list.get(1);
        int index = reward.getId();
        assertThat(rewardPostgreDAO.get(index), is(reward));
    }
    
    @Test
    public void testGetByProject() {
        int id = projects.get(0).getId();
        rewardPostgreDAO.getByProject(id).forEach(p -> assertThat(p.getProject().getId(), is(id)));
    }

}
