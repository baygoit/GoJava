package ua.dborisenko.kickstarter;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.dao.InvestmentDao;
import ua.dborisenko.kickstarter.dao.NoResultException;
import ua.dborisenko.kickstarter.dao.ProjectDao;
import ua.dborisenko.kickstarter.dao.QuestionDao;
import ua.dborisenko.kickstarter.dao.QuoteDao;
import ua.dborisenko.kickstarter.dao.RewardDao;
import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;
import ua.dborisenko.kickstarter.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class KickstarterTest {

    @Mock
    private RequestDispatcher dispatcher;
    @Mock
    private QuoteDao quoteDao;
    @Mock
    private ProjectDao projectDao;
    @Mock
    private CategoryDao categoryDao;
    @Mock
    private QuestionDao questionDao;
    @Mock
    private InvestmentDao investmentDao;
    @Mock
    private RewardDao rewardDao;
    @Mock
    private ServletContext context;
    @InjectMocks
    private Kickstarter kickstarter;
    private MockHttpServletRequest request;
    private HttpServletResponse response;

    @Before
    public void prepare() {
        request = new MockHttpServletRequest();
        response = mock(HttpServletResponse.class);
        when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
    }

    @Test
    public void doGetCategoriesTest() throws ServletException, IOException {
        Quote quote = new Quote();
        when(quoteDao.getRandomQuote()).thenReturn(quote);
        request.addParameter("page", "categories");
        kickstarter.doGet(request, response);
        verify(context).getRequestDispatcher(Kickstarter.CATEGORIES_JSP_PATH);
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void doGetCategoryTest() throws ServletException, IOException {
        Category category = new Category();
        when(categoryDao.getCategoryById(anyInt())).thenReturn(category);
        request.setQueryString("foo");
        request.addParameter("page", "category");
        request.addParameter("id", "1");
        kickstarter.doGet(request, response);
        verify(context).getRequestDispatcher(Kickstarter.CATEGORY_JSP_PATH);
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void doGetCategoryNoResultTest() throws ServletException, IOException {
        when(categoryDao.getCategoryById(anyInt())).thenThrow(new NoResultException("foo"));
        request.setQueryString("foo");
        request.addParameter("page", "category");
        request.addParameter("id", "1");
        kickstarter.doGet(request, response);
        verify(response).sendError(404);
    }

    @Test
    public void doGetProjectTest() throws ServletException, IOException {
        Project project = new Project();
        when(projectDao.getProjectById(anyInt())).thenReturn(project);
        request.setQueryString("foo");
        request.addParameter("page", "project");
        request.addParameter("id", "1");
        kickstarter.doGet(request, response);
        verify(context).getRequestDispatcher(Kickstarter.PROJECT_JSP_PATH);
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void doGetProjectNoResultTest() throws ServletException, IOException {
        when(projectDao.getProjectById(anyInt())).thenThrow(new NoResultException("foo"));
        request.setQueryString("foo");
        request.addParameter("page", "project");
        request.addParameter("id", "1");
        kickstarter.doGet(request, response);
        verify(response).sendError(404);
    }

    @Test
    public void doGetInvestmentTest() throws ServletException, IOException {
        Project project = new Project();
        when(projectDao.getProjectById(anyInt())).thenReturn(project);
        request.setQueryString("foo");
        request.addParameter("page", "investment");
        request.addParameter("project_id", "1");
        kickstarter.doGet(request, response);
        verify(context).getRequestDispatcher(Kickstarter.INVESTMENT_JSP_PATH);
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void doGetInvestmentNoResultTest() throws ServletException, IOException {
        when(projectDao.getProjectById(anyInt())).thenThrow(new NoResultException("foo"));
        request.setQueryString("foo");
        request.addParameter("page", "investment");
        request.addParameter("project_id", "1");
        kickstarter.doGet(request, response);
        verify(response).sendError(404);
    }

    @Test
    public void doGetWrongPageTest() throws ServletException, IOException {
        request.setQueryString("foo");
        request.addParameter("page", "bar");
        kickstarter.doGet(request, response);
        verify(response).sendError(404);
    }

    @Test
    public void doGetWrongFormatTest() throws ServletException, IOException {
        request.setQueryString("foo");
        request.addParameter("page", "category");
        request.addParameter("id", "foo");
        kickstarter.doGet(request, response);
        verify(response).sendError(400);
    }

    @Test
    public void doPostQuestionTest() throws ServletException, IOException {
        request.addParameter("requested_action", "ADD_QUESTION");
        request.addParameter("project_id", "1");
        request.addParameter("question_request", "foo");
        kickstarter.doPost(request, response);
        verify(questionDao).addQuestion(eq(1), any(Question.class));
    }

    @Test
    public void doPostQuestionWrongFormatTest() throws ServletException, IOException {
        request.addParameter("requested_action", "ADD_QUESTION");
        request.addParameter("project_id", "bar");
        request.addParameter("question_request", "foo");
        kickstarter.doPost(request, response);
        verify(response).sendError(400);
    }

    @Test
    public void doPostInvestmentTest() throws ServletException, IOException {
        request.addParameter("requested_action", "ADD_INVESTMENT");
        request.addParameter("project_id", "1");
        request.addParameter("cardholder_name", "foo");
        request.addParameter("card_number", "bar");
        request.addParameter("amount", "0");
        request.addParameter("custom_amount", "10");
        kickstarter.doPost(request, response);
        verify(investmentDao).addInvestment(eq(1), any(Investment.class));
    }

    @Test
    public void doPostInvestmentNegativeTest() throws ServletException, IOException {
        request.addParameter("requested_action", "ADD_INVESTMENT");
        request.addParameter("project_id", "1");
        request.addParameter("cardholder_name", "foo");
        request.addParameter("card_number", "bar");
        request.addParameter("amount", "-10");
        kickstarter.doPost(request, response);
        verify(response).sendError(400);
    }

    @Test
    public void doPostInvestmentWrongFormatTest() throws ServletException, IOException {
        request.addParameter("requested_action", "ADD_INVESTMENT");
        request.addParameter("project_id", "1");
        request.addParameter("cardholder_name", "foo");
        request.addParameter("card_number", "bar");
        request.addParameter("amount", "aaa");
        kickstarter.doPost(request, response);
        verify(response).sendError(400);
    }

    @Test
    public void doPostWrongActionTest() throws ServletException, IOException {
        request.addParameter("requested_action", "foo");
        kickstarter.doPost(request, response);
        verify(response).sendError(404);
    }

}
