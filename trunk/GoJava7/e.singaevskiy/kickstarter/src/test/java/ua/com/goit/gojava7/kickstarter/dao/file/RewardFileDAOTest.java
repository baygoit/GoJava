package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.dao.ProjectStorage;

@RunWith(value=MockitoJUnitRunner.class)
public class RewardFileDAOTest {
    Class<Reward> persistentClass = Reward.class;
    RewardFileDAO fs;
    List<Reward> list = new ArrayList<>();
    @Mock
    private ProjectStorage projectFileDAO;
    private String filePath = "src/test/resources/storages/file/%name%.CSV".replace("%name%", persistentClass.getSimpleName());
    
    @Before
    public void setUp(){
        
        fs = new RewardFileDAO(filePath);
        List<Project> pr = new ArrayList<>();
        pr.add(new Project(1, "p1", "a1", null));
        pr.add(new Project(2, "p2", "a2", null));
        
        Mockito.when(projectFileDAO.getAll()).thenReturn(pr);
        
        list.add(new Reward(1, projectFileDAO.get(1), "a1", 100L));
        list.add(new Reward(2, projectFileDAO.get(1), "a2", 200L));
        list.add(new Reward(3, projectFileDAO.get(2), "a3", 300L));
        
        fs.clear();
        fs.addAll(list);

    }
    
    @After
    public void tearDown() throws Exception {
        Path path = Paths.get(filePath);
        if (path.toFile().exists()) {
            Files.delete(path);
        }
    }
    
    @Test
    public void testGetAll() {
        assertThat(fs.getAll(), is(list));
    }

    @Test
    public void testAddGet() {
        int id = 42;
        Reward reward = new Reward(id, projectFileDAO.get(2), "a1", 100L);
        fs.add(reward);
        assertThat(fs.get(id), is(reward));
    }

    @Test
    public void testAddAll() {
        fs.clear();
        fs.addAll(list);
        assertThat(fs.getAll(), is(list));
    }

}
