package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext*.xml")
public class QuestionsPostgreDAOTest {

    List<Question> list;
    
    @Autowired
    QuestionPostgreDAO questionPostgreDAO;
    
    @Autowired
    ProjectPostgreDAO projectPostgreDAO;

	private List<Project> projects;

    @Before
    public void setUp() throws Exception {
    	projects = projectPostgreDAO.getAll();
    	
        questionPostgreDAO.clear();
        
        list = new ArrayList<>();
        list.add(new Question(projects.get(0), "a1", "t1"));
        list.add(new Question(projects.get(0), "a2", "t2"));
        list.add(new Question(projects.get(1), "a3", "t3"));
        
        questionPostgreDAO.addAll(list);
    }

    @Test
    public void testAddGetAll() {
        assertThat(questionPostgreDAO.getAll(), is(list));
    }
    
    @Test
    public void testAddGet() {
    	questionPostgreDAO.clear();
        list.forEach(questionPostgreDAO::add);
        Question question = questionPostgreDAO.getAll().get(0);
		int index = question.getId();
        assertThat(questionPostgreDAO.get(index), is(question));
    }
    
    @Test
    public void testGetByProject() {
        int id = projects.get(0).getId();
        questionPostgreDAO.getByProject(id).forEach(p -> assertThat(p.getProject().getId(), is(id)));
    }
}
