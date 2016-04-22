package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class QuestionDaoTest {

    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void getAllForProjectTest() {
        Category category = new Category();
        categoryDao.add(category);
        Project project = new Project();
        project.setCategory(category);
        project.setName("testname");
        projectDao.add(project);
        Question question = new Question();
        question.setRequest("testrequest");
        question.setReply("testreply");
        question.setProject(project);
        questionDao.add(question);
        questionDao.getAllForProject(project);
        assertThat(project.getQuestions().isEmpty(), is(false));
        for (Question currentQuestion : project.getQuestions()) {
            assertThat(currentQuestion.getRequest(), is("testrequest"));
            assertThat(currentQuestion.getReply(), is("testreply"));
        }
    }

}
