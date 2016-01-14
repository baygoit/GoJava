package ua.com.goit.gojava7.kickstarter.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CategoryDaoTest {

    @Mock
    private ProjectDao projectDao;

    @InjectMocks
    private CategoryDao categoryDao;

    @Test
    public void testGetProjects() {
        categoryDao.getProjects(1L);
        verify(projectDao).getByCategory(1L);
    }
}
