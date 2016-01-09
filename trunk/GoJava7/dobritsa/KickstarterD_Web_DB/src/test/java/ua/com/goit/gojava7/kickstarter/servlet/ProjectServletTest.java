package ua.com.goit.gojava7.kickstarter.servlet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.powermock.modules.junit4.PowerMockRunner;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.models.Category;
import ua.com.goit.gojava7.kickstarter.models.Project;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SpringBeanAutowiringSupport.class)
public class ProjectServletTest {

    @Mock
    private ProjectDao projectDao;

    @Mock
    private CategoryDao categoryDao;

    @Mock
    private PaymentDao paymentDao;

    @InjectMocks
    private ProjectServlet projectServlet;

    @Test
    public void testInit() throws Exception {
        PowerMockito.mockStatic(SpringBeanAutowiringSupport.class);

        projectServlet.init();

        PowerMockito.verifyStatic();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(anyObject());
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRequestDispatcher(anyString())).thenReturn(mock(RequestDispatcher.class));
        when(request.getParameter("id")).thenReturn("1");
    }
}
