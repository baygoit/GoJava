package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.dao.memory.Memory;

public class CategoryFileDAOTest {
    
    FileDAO<Category> fs;
    List<Category> list = new ArrayList<>();
    
    @Before
    public void setUp(){
        Class<Category> persistentClass = Category.class;
        fs = new FileDAO<Category>(persistentClass, 
                "target/generated-test-sources/storages/file/%name%.txt".replace("%name%", persistentClass.getSimpleName()));
        
        list.add(new Category("c1"));
        list.add(new Category("c2"));
        list.add(new Category(null));
        
        list = new Memory().getCategories();
        
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
        Category element = new Category("cat");
        fs.add(element);
        assertThat(fs.get(++lastIndex), is(element));
    }

    @Test
    public void testAddAll() {
        fs.clear();
        fs.addAll(list);
        assertThat(fs.getAll(), is(list));
    }

}
