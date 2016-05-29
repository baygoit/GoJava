package ua.dborisenko.kickstarter.dao;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
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

import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDaoTest {

    @Mock
    private EntityManager em;
    @Mock
    private TypedQuery<Project> query;
    @Mock
    private EntityGraph<Project> graph;
    @InjectMocks
    private ProjectDao projectDao;

    @Test
    public void getTest() {
        when(em.find(any(), anyInt())).thenReturn(new Project());
        projectDao.get(42);
        verify(em).find(Project.class, 42);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getWithProjectsEmptyTest() {
        projectDao.get(42);
    }

    @Test
    public void getWithRewardsTest() {
        doReturn(graph).when(em).createEntityGraph(anyString());
        when(em.find(any(), eq(42), anyMapOf(String.class, Object.class))).thenReturn(new Project());
        projectDao.getWithRewards(42);
        verify(em).getEntityGraph("graph.Project.rewards");
        verify(em).find(any(), eq(42), anyMapOf(String.class, Object.class));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getWithRewardsEmptyTest() {
        doReturn(graph).when(em).createEntityGraph(anyString());
        projectDao.getWithRewards(42);
    }

    @Test
    public void getWithQuestionsTest() {
        doReturn(graph).when(em).createEntityGraph(anyString());
        when(em.find(any(), eq(42), anyMapOf(String.class, Object.class))).thenReturn(new Project());
        projectDao.getWithQuestions(42);
        verify(em).getEntityGraph("graph.Project.questions");
        verify(em).find(any(), eq(42), anyMapOf(String.class, Object.class));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getWithQuestionsEmptyTest() {
        doReturn(graph).when(em).createEntityGraph(anyString());
        projectDao.getWithQuestions(42);
    }

    @Test
    public void addInvestmentTest() {
        Investment investment = new Investment();
        projectDao.addInvestment(investment);
        verify(em).persist(investment);
    }

    @Test
    public void addQuestionTest() {
        Question question = new Question();
        projectDao.addQuestion(question);
        verify(em).persist(question);
    }
}
