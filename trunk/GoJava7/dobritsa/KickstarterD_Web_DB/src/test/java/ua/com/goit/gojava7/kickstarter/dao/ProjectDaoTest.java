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

}
