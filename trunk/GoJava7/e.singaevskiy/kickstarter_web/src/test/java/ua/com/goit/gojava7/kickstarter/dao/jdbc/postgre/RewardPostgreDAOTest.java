package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardPostgreDAOTest {

    List<Reward> list;
    RewardPostgreDAO dao;

    @Before
    public void setUp() throws Exception {
        dao = new RewardPostgreDAO();
		dao.setJdbcTemplate(TestDaoFactory.setupJdbcTemplate()); 
        
        list = new ArrayList<>();
        list.add(new Reward(1, 0, "r1", 113));
        list.add(new Reward(2, 0, "r2", 44));       
    }
    
    @After
    public void tearDown() throws Exception {
        dao.clear();
    }

    @Test
    public void testAddGetAll() {
        dao.addAll(list);
        assertThat(dao.getAll(), is(list));
    }
    
    @Test
    public void testAddGet() {
        list.forEach(dao::add);
        Reward reward = list.get(1);
        int index = reward.getId();
        assertThat(dao.get(index), is(reward));
    }

}
