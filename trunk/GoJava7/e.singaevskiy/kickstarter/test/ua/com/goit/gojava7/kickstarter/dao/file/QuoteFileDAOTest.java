package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Quote;

public class QuoteFileDAOTest {
    
    FileDAO<Quote> fs;
    List<Quote> list = new ArrayList<>();
    
    @Before
    public void setUp(){
        Class<Quote> persistentClass = Quote.class;
        fs = new FileDAO<Quote>(persistentClass, 
                "target/generated-test-sources/storages/file/%name%.txt".replace("%name%", persistentClass.getSimpleName()));
        
        list.add(new Quote("a1", "t1"));
        list.add(new Quote("a2", "t2"));
        list.add(new Quote(null, null));
        
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
        Quote quote = new Quote("author", "text");
        fs.add(quote);
        assertThat(fs.get(++lastIndex), is(quote));
    }

    @Test
    public void testAddAll() {
        fs.clear();
        fs.addAll(list);
        assertThat(fs.getAll(), is(list));
    }

}
