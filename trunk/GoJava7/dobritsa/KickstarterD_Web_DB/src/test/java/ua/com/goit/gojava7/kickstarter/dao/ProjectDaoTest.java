package ua.com.goit.gojava7.kickstarter.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.com.goit.gojava7.kickstarter.model.Project;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDaoTest {

    @Mock
    private QuestionDao questionDao;

    @Mock
    private CategoryDao categoryDao;

    @InjectMocks
    private ProjectDao projectDao;

    @Test
    public void testGetQuestions() {
        projectDao.getQuestions(1L);
        verify(questionDao).getByProject(1L);
    }
    @Test
    public void testGetCategory() {
        Project project = new Project();
        projectDao.getCategory(project);
        verify(categoryDao).get(anyLong());
    }
}
