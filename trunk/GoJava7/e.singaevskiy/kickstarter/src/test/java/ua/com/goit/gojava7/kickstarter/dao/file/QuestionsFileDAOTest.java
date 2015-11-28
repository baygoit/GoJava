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

import ua.com.goit.gojava7.kickstarter.dao.QuestionsDAO;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionsFileDAOTest {
    Class<Question> persistentClass = Question.class;
    QuestionsDAO fs;
    List<Question> list = new ArrayList<>();
    private String filePath = "src/test/resources/storages/file/%name%.CSV".replace("%name%", persistentClass.getSimpleName());
    
    @Before
    public void setUp(){
        
        fs = new QuestionFileDAO(filePath);
        
        list.add(new Question(1, "a1", "t1"));
        list.add(new Question(2, null, null));
        list.add(new Question(3, "a2", "t2"));        
        
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
        assertThat(fs.getAll(), is(list));
    }

    @Test
    public void testAdd() {
        Question element = new Question(1, "", "");
        fs.add(element);
        assertThat(fs.getAll(), hasItem(element));
    }
    
    @Test
    public void testGet() {
        int index = 0;
        Question element = fs.getAll().get(index);
        assertThat(fs.get(index), is(element));
    }

}
