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

import ua.com.goit.gojava7.kickstarter.beans.Category;

public class CategoryFileDAOTest {
    FileDAO<Category> fs;
    List<Category> list = new ArrayList<>();
    String filePath = "src/test/resources/storages/file/%name%.CSV".replace("%name%", Category.class.getSimpleName());
    
    @Before
    public void setUp(){
        
        fs = new CategoryFileDAO(filePath);
        
        list.add(new Category(1, "c1"));
        list.add(new Category(2, "c2"));
        list.add(new Category(3, "c3"));
        
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
        int id = 55;
        Category element = new Category(4, "cat");
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

}
