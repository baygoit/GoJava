package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.hasItem;
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

import ua.com.goit.gojava7.kickstarter.beans.Quote;

public class QuoteFileDAOTest {
    Class<Quote> persistentClass = Quote.class;
    FileDAO<Quote> fs;
    List<Quote> list = new ArrayList<>();
    private String filePath = "src/test/resources/storages/file/%name%.CSV".replace("%name%", persistentClass.getSimpleName());
    
    @Before
    public void setUp(){
        
        fs = new FileDAO<Quote>(persistentClass, filePath);
        
        list.add(new Quote("a1", "t1"));
        list.add(new Quote("a2", "t2"));
        list.add(new Quote(null, null));
        
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
    public void testAddAllGetAll() {
        fs.clear();
        fs.addAll(list);
        List<Quote> all = fs.getAll();
        for (Quote quote : list) {
            assertThat(all, hasItem(quote));
        }
        assertThat(all.size(), is(list.size()));
    }

    @Test
    public void testAdd() {
        Quote element = new Quote("", "");
        fs.add(element);
        assertThat(fs.getAll(), hasItem(element));
    }
    
    @Test
    public void testGet() {
        int index = 0;
        Quote element = fs.getAll().get(index);
        assertThat(list, hasItem(element));
        assertThat(fs.get(index), is(element));
    }

}
