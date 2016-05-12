package ua.dborisenko.kickstarter.dao;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyMapOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.EmptyResultDataAccessException;

import ua.dborisenko.kickstarter.domain.Category;

@RunWith(MockitoJUnitRunner.class)
public class CategoryDaoTest {
    @Mock
    private EntityManager em;
    @Mock
    private TypedQuery<Category> query;
    @Mock
    private EntityGraph<Category> graph;
    @InjectMocks
    private CategoryDao categoryDao;

    @Test
    public void getWithProjectsTest() {
        doReturn(graph).when(em).createEntityGraph(anyString());
        when(em.find(any(), eq(42), anyMapOf(String.class, Object.class))).thenReturn(new Category());
        categoryDao.getWithProjects(42);
        verify(em).getEntityGraph("graph.Category.projects");
        verify(em).find(any(), eq(42), anyMapOf(String.class, Object.class));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getWithProjectsEmptyTest() {
        doReturn(graph).when(em).createEntityGraph(anyString());
        categoryDao.getWithProjects(42);
    }

    @Test
    public void getAllTest() {
        when(em.createNamedQuery("Category.getAll")).thenReturn(query);
        categoryDao.getAll();
        verify(em).createNamedQuery("Category.getAll");
        verify(query).getResultList();
    }
}
