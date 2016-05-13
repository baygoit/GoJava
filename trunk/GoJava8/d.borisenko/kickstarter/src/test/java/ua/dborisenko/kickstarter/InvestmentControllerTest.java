package ua.dborisenko.kickstarter;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.EmptyResultDataAccessException;

import ua.dborisenko.kickstarter.dao.ProjectDao;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Reward;

@RunWith(MockitoJUnitRunner.class)
public class InvestmentControllerTest {

    @Mock
    private RequestDispatcher dispatcher;
    @Mock
    private ServletContext context;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private ProjectDao projectDao;
    @InjectMocks
    private InvestmentController investmentController;

    @Before
    public void setUp() {
        when(request.getServletContext()).thenReturn(context);
        when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
    }

    @Test
    public void showInvestmentTest() throws ServletException, IOException {
        when(request.getParameter(InvestmentController.PROJECT_ID_PARAM_NAME)).thenReturn("42");
        Project project = mock(Project.class);
        List<Reward> rewards = new ArrayList<>();
        when(project.getRewards()).thenReturn(rewards);
        when(projectDao.getWithRewards(42)).thenReturn(project);
        investmentController.showInvestment(request, response);
        verify(request).setAttribute(InvestmentController.PROJECT_ATTR_NAME, project);
        verify(request).setAttribute(InvestmentController.REWARDS_ATTR_NAME, rewards);
        verify(context).getRequestDispatcher(InvestmentController.INVESTMENT_JSP_PATH);
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void showInvestmentEmptyTest() throws ServletException, IOException {
        when(request.getParameter(InvestmentController.PROJECT_ID_PARAM_NAME)).thenReturn("42");
        when(projectDao.getWithRewards(42)).thenThrow(new EmptyResultDataAccessException(1));
        investmentController.showInvestment(request, response);
        verify(response).sendError(HttpServletResponse.SC_NOT_FOUND, ErrorText.PROJECT_NOT_FOUND);
    }

    @Test
    public void showInvestmentWrongNumberTest() throws ServletException, IOException {
        when(request.getParameter(InvestmentController.PROJECT_ID_PARAM_NAME)).thenReturn("foo");
        investmentController.showInvestment(request, response);
        verify(response).sendError(HttpServletResponse.SC_BAD_REQUEST, ErrorText.NUMBER_FORMAT);
    }

    @Test
    public void addInvestmentTest() throws ServletException, IOException {
        when(request.getParameter(InvestmentController.PROJECT_ID_PARAM_NAME)).thenReturn("42");
        when(request.getParameter(InvestmentController.AMOUNT_PARAM_NAME)).thenReturn("100");
        investmentController.addInvestment(request, response);
        verify(projectDao).addInvestment(any(Investment.class));
        verify(response).sendRedirect(InvestmentController.PROJECT_OUT_URL + 42);
    }

    @Test
    public void addInvestmentCustomAmountTest() throws ServletException, IOException {
        when(request.getParameter(InvestmentController.PROJECT_ID_PARAM_NAME)).thenReturn("42");
        when(request.getParameter(InvestmentController.AMOUNT_PARAM_NAME)).thenReturn("0");
        when(request.getParameter(InvestmentController.CUSTOM_AMOUNT_PARAM_NAME)).thenReturn("100");
        investmentController.addInvestment(request, response);
        verify(projectDao).addInvestment(any(Investment.class));
        verify(response).sendRedirect(InvestmentController.PROJECT_OUT_URL + 42);
    }

    @Test
    public void addInvestmentZeroAmountTest() throws ServletException, IOException {
        when(request.getParameter(InvestmentController.PROJECT_ID_PARAM_NAME)).thenReturn("42");
        when(request.getParameter(InvestmentController.AMOUNT_PARAM_NAME)).thenReturn("0");
        when(request.getParameter(InvestmentController.CUSTOM_AMOUNT_PARAM_NAME)).thenReturn("0");
        investmentController.addInvestment(request, response);
        verify(response).sendError(HttpServletResponse.SC_BAD_REQUEST, ErrorText.NEGATIVE_AMOUNT);
    }

    @Test
    public void addInvestmentWrongNumberTest() throws ServletException, IOException {
        when(request.getParameter(InvestmentController.PROJECT_ID_PARAM_NAME)).thenReturn("42");
        when(request.getParameter(InvestmentController.AMOUNT_PARAM_NAME)).thenReturn("foo");
        when(request.getParameter(InvestmentController.CUSTOM_AMOUNT_PARAM_NAME)).thenReturn("0");
        investmentController.addInvestment(request, response);
        verify(response).sendError(HttpServletResponse.SC_BAD_REQUEST, ErrorText.NUMBER_FORMAT);
    }
}
