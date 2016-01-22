package ua.com.goit.gojava7.kickstarter.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SpringBeanAutowiringSupport.class)
public class PaymentCheckServletTest {

    @Mock
    private PaymentDao paymentDao;

    @Mock
    private ProjectDao projectDao;

    @InjectMocks
    private ProjectController projectController;

    @Ignore
    @Test
    public void testDoGetWithTrueCreatePayment() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRequestDispatcher(anyString())).thenReturn(mock(RequestDispatcher.class));
        when(request.getParameter("projectId")).thenReturn("1");
        when(request.getParameter("amount")).thenReturn("100");
        when(request.getParameter("name")).thenReturn("nameTest");
        when(request.getParameter("card")).thenReturn("cardTest");

        Project project = new Project();
        when(projectDao.get(anyLong())).thenReturn(project);

        Category category = new Category();
        //when(projectDao.getCategory(any(Project.class))).thenReturn(category);


        //when(paymentDao.createPayment(anyObject(), anyObject(), anyLong(), any(Project.class))).thenReturn(true);

        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);

        //paymentCheckServlet.doPost(request, response);

        verify(request).setAttribute("category", category);
        verify(request).setAttribute("project", project);
        verify(request).setAttribute("amount", 100L);
        verify(request).getRequestDispatcher(contains("/WEB-INF/jsp/paymentOk.jsp"));
    }

    @Ignore
    @Test
    public void testDoGetWithFalseCreatePayment() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRequestDispatcher(anyString())).thenReturn(mock(RequestDispatcher.class));
        when(request.getParameter("projectId")).thenReturn("1");
        when(request.getParameter("amount")).thenReturn("100");
        when(request.getParameter("name")).thenReturn("nameTest");
        when(request.getParameter("card")).thenReturn("cardTest");

        Project project = new Project();
        when(projectDao.get(anyLong())).thenReturn(project);

        Category category = new Category();
        //when(projectDao.getCategory(any(Project.class))).thenReturn(category);


        //when(paymentDao.createPayment(anyObject(), anyObject(), anyLong(), any(Project.class))).thenReturn(false);

        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);

        //paymentCheckServlet.doPost(request, response);

        verify(request).setAttribute("category", category);
        verify(request).setAttribute("project", project);
        verify(request).setAttribute("amount", 100L);
        verify(request).setAttribute("message", "-----Wrong data-----");
        verify(request).getRequestDispatcher(contains("/WEB-INF/jsp/payment.jsp"));
    }
}
