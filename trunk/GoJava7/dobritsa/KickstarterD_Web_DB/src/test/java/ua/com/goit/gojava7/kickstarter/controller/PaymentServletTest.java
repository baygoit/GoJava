package ua.com.goit.gojava7.kickstarter.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ua.com.goit.gojava7.kickstarter.validator.MyValidator;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Reward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SpringBeanAutowiringSupport.class)
public class PaymentServletTest {

    @Mock
    private ProjectDao projectDao;
    @Mock
    private RewardDao rewardDao;
    @Mock
    private MyValidator myValidator;

    @InjectMocks
    private ProjectController projectController;

    @Test
    @Ignore
    public void testDoGetWithoutRewardWithValidAmount() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRequestDispatcher(anyString())).thenReturn(mock(RequestDispatcher.class));
        when(request.getParameter("id")).thenReturn("0");
        when(request.getParameter("projectId")).thenReturn("1");
        when(request.getParameter("amount")).thenReturn("100");

        Category category = new Category();
        Project project = new Project();
        project.setCategory(category);

        when(projectDao.get(anyLong())).thenReturn(project);
        when(myValidator.validateAmountOfPledge(anyObject())).thenReturn(true);

        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);

       // paymentServlet.doGet(request, response);

        verify(request).setAttribute("category", category);
        verify(request).setAttribute("project", project);
        verify(request).setAttribute("amount", 100L);
        verify(request).getRequestDispatcher(contains("/WEB-INF/jsp/payment.jsp"));
    }

    @Ignore
    @Test
    public void testDoGetWithoutRewardWithWrongAmount() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRequestDispatcher(anyString())).thenReturn(mock(RequestDispatcher.class));
        when(request.getParameter("id")).thenReturn("0");
        when(request.getParameter("projectId")).thenReturn("1");
        when(request.getParameter("amount")).thenReturn("100");

        Category category = new Category();
        Project project = new Project();
        project.setCategory(category);
        List<Reward> rewards = new ArrayList<>();

        when(projectDao.get(anyLong())).thenReturn(project);
        when(rewardDao.getByProject(anyLong())).thenReturn(rewards);
        when(myValidator.validateAmountOfPledge(anyObject())).thenReturn(false);

        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);

      //  paymentServlet.doGet(request, response);

        verify(request).setAttribute("category", category);
        verify(request).setAttribute("project", project);
        verify(request).setAttribute("rewards", rewards);
        verify(request).setAttribute("message", "-----Wrong amount-----");
        verify(request).getRequestDispatcher(contains("/WEB-INF/jsp/rewards.jsp"));
    }

    @Ignore
    @Test
    public void testDoGetWithReward() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRequestDispatcher(anyString())).thenReturn(mock(RequestDispatcher.class));
        when(request.getParameter("id")).thenReturn("1");

        Category category = new Category();
        Project project = new Project();
        project.setCategory(category);
        Reward reward = new Reward();
        reward.setAmount(300L);
        reward.setProject(project);

        when(rewardDao.get(anyLong())).thenReturn(reward);

        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);

       // paymentServlet.doGet(request, response);

        verify(request).setAttribute("category", category);
        verify(request).setAttribute("project", project);
        verify(request).setAttribute("amount", 300L);
        verify(request).getRequestDispatcher(contains("/WEB-INF/jsp/payment.jsp"));
    }
}
