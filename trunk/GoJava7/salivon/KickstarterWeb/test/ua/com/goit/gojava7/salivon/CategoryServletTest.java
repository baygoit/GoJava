package ua.com.goit.gojava7.salivon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import static org.mockito.Mockito.*;
import ua.com.goit.gojava7.salivon.dao.DataType;

public class CategoryServletTest {

    @Test
    public void testProcessRequest() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        ServletContext context = mock(ServletContext.class);
        CategoryServlet instance = new CategoryServlet();
        CategoryServlet spy = spy(instance);
        doNothing().when(spy).initField(request);
        when(request.getRequestDispatcher("category.jsp")).thenReturn(dispatcher);
        spy.processRequest(request, response);

    }

    @Test
    public void testDoGet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        ServletContext context = mock(ServletContext.class);
        CategoryServlet instance = new CategoryServlet();
        CategoryServlet spy = spy(instance);
        doNothing().when(spy).processRequest(request, response);
        spy.doGet(request, response);
        verify(spy).processRequest(request, response);

    }

    @Test
    public void testInitField() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        ServletContext context = mock(ServletContext.class);
        CategoryServlet instance = new CategoryServlet();
        CategoryServlet spy = spy(instance);
        doReturn(context).when(spy).getServletContext();
        when(context.getAttribute("mode")).thenReturn(DataType.FILE);
        when(request.getParameter("id")).thenReturn("1");
        spy.initField(request);
        when(context.getAttribute("mode")).thenReturn(DataType.MEMORY);
        spy.initField(request);
    }

}
