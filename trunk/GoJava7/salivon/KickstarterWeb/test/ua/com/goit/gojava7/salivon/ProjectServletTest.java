package ua.com.goit.gojava7.salivon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ua.com.goit.gojava7.salivon.dao.DaoFactory;
import ua.com.goit.gojava7.salivon.dao.DataType;

public class ProjectServletTest {

    @Test
    public void testProcessRequest() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpSession session = mock(HttpSession.class);
        ServletContext context = mock(ServletContext.class);
        ProjectServlet instance = new ProjectServlet();
        ProjectServlet spy = spy(instance);
        doNothing().when(spy).initField(request);
        spy.project = DaoFactory.getProjectDao(DataType.MEMORY).getProject(2);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("project.jsp")).thenReturn(dispatcher);
        spy.processRequest(request, response);

    }

    @Test
    public void testDoGet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        ServletContext context = mock(ServletContext.class);
        ProjectServlet instance = new ProjectServlet();
        ProjectServlet spy = spy(instance);
        doNothing().when(spy).processRequest(request, response);
        spy.doGet(request, response);
        verify(spy).processRequest(request, response);
    }

    @Test
    public void testInitField() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        ServletContext context = mock(ServletContext.class);
        HttpSession session = mock(HttpSession.class);
        ProjectServlet instance = new ProjectServlet();
        ProjectServlet spy = spy(instance);
        doReturn(context).when(spy).getServletContext();
        when(context.getAttribute("mode")).thenReturn(DataType.FILE);
        when(request.getParameter("id")).thenReturn("1");
        spy.initField(request);
        when(context.getAttribute("mode")).thenReturn(DataType.MEMORY);
        spy.initField(request);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("idProject")).thenReturn(2);
        when(request.getParameter("id")).thenReturn(null);
        spy.initField(request);

    }

}
