package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.memory.util.Memory;

public class ProjectFileDAOTest {
    Class<Project> persistentClass = Project.class;
    ProjectFileDAO fs;
    List<Project> list = new ArrayList<>();
    private String filePath = "src/test/resources/storages/file/%name%.CSV".replace("%name%", persistentClass.getSimpleName());
    
    @Before
    public void setUp(){
        
        fs = new ProjectFileDAO(filePath);
        
        list = new Memory().getProjects();
        
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
        int id = 33;
        Project element = new Project();
        element.setId(id);
        fs.add(element);
        assertThat(fs.get(id), is(element));
    }

    @Test
    public void testAddAll() {
        fs.clear();
        fs.addAll(list);
        assertThat(fs.getAll(), is(list));
    }
    
    @Test
    public void testGetByCategory() {
        List<Project> pList = new ArrayList<>();
        int categoryId = 33;
        pList.add(new Project(22, "p1", null, categoryId));
        pList.add(new Project(44,"p2", null, categoryId));
        
        fs.addAll(pList);
        fs.add(new Project(55, "p3", null, 2));

        assertThat(fs.getAll(), not(pList));
        assertThat(fs.getByCategory(categoryId), is(pList));
    }
    
}
