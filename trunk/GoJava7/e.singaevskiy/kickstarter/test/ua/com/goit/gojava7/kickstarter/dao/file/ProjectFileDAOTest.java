package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.memory.Memory;

public class ProjectFileDAOTest {
    
    ProjectFileDAO fs;
    List<Project> list = new ArrayList<>();
    
    @Before
    public void setUp(){
        Class<Project> persistentClass = Project.class;
        fs = new ProjectFileDAO("target/generated-test-sources/storages/file/%name%.txt".replace("%name%", persistentClass.getSimpleName()));
        
        list = new Memory().getProjects();
        
        fs.clear();
        fs.addAll(list);

    }
    
    @After
    public void tearDown() {
        //fsQuote.clear();
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
        int lastIndex = list.size()-1;
        Project element = new Project();
        fs.add(element);
        assertThat(fs.get(++lastIndex), is(element));
    }

    @Test
    public void testAddAll() {
        fs.clear();
        fs.addAll(list);
        assertThat(fs.getAll(), is(list));
    }
    
    @Test
    public void testGetByCategory() {
        Category category = new Category("cat");
        List<Project> pList = new ArrayList<>();
        pList.add(new Project("p1", null, category));
        pList.add(new Project("p2", null, category));
        
        fs.addAll(pList);
        fs.add(new Project("p3", null, new Category("cat2")));

        assertThat(fs.getAll(), not(pList));
        assertThat(fs.getByCategory(category), is(pList));
    }
    
}
