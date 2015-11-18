package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Pledge;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.User;
import ua.com.goit.gojava7.kickstarter.dao.memory.Memory;

public class PledgeFileDAOTest {

    PledgeFileDAO fs;
    List<Pledge> list = new ArrayList<>();
    
    @Before
    public void setUp(){
        Class<Pledge> persistentClass = Pledge.class;
        fs = new PledgeFileDAO("src/test/resources/storages/file/%name%.txt".replace("%name%", persistentClass.getSimpleName()));
        
        list = new Memory().getPledges();
        
        fs.clear();
        fs.addAll(list);

    }
    
    @After
    public void tearDown() {
        //fs.clear();
    }
    
    @Test
    public void testGetAll() {
        assertThat(fs.getAll(), is(list));
    }

    @Test
    public void testGet() {
        for (int i = 0; i < list.size(); i++) {
            assertThat(fs.get(i), is(list.get(i)));
        }
    }

    @Test
    public void testAdd() {
        Pledge element = new Pledge();
        fs.add(element);
        assertThat(fs.getAll(), hasItem(element));
    }

    @Test
    public void testAddAll() {
        fs.clear();
        fs.addAll(list);
        assertThat(fs.getAll(), is(list));
    }
    
    @Test
    public void testGetByProject() {
        Project project = new Project("proj", new User("usr"), new Category("cat"));
        List<Pledge> pList = new ArrayList<>();
        pList.add(new Pledge(project, null));
        pList.add(new Pledge(project, null));
        
        fs.addAll(pList);
        fs.add(new Pledge(new Project(), null));

        assertThat(fs.getAll(), not(pList));
        assertThat(fs.getByProject(project), is(pList));
    }

}
