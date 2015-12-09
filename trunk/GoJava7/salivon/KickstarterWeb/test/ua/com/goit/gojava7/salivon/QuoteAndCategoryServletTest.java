package ua.com.goit.gojava7.salivon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import static org.mockito.Mockito.*;
import ua.com.goit.gojava7.salivon.dao.DataType;

public class QuoteAndCategoryServletTest {

    @Test
    public void testInit() throws Exception {
        ServletContext context = mock(ServletContext.class);
        QuoteAndCategoryServlet instance = new QuoteAndCategoryServlet();
        QuoteAndCategoryServlet spy = spy(instance);
        doReturn(context).when(spy).getServletContext();
        when(context.getInitParameter("mode")).thenReturn("db");
        spy.init();
        when(context.getInitParameter("mode")).thenReturn("memory");
        spy.init();
        when(context.getInitParameter("mode")).thenReturn("file");
        spy.init();
        when(context.getInitParameter("mode")).thenReturn("");
        spy.init();
        when(context.getInitParameter("mode")).thenReturn(null);
        spy.init();
        when(context.getInitParameter("mode")).thenReturn("gfghfg");
        spy.init();

    }

    @Test
    public void testProcessRequest() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        ServletContext context = mock(ServletContext.class);
        QuoteAndCategoryServlet instance = new QuoteAndCategoryServlet();
        QuoteAndCategoryServlet spy = spy(instance);
        doReturn(context).when(spy).getServletContext();
        when(context.getAttribute("mode")).thenReturn(DataType.MEMORY);
        when(request.getRequestDispatcher("index.jsp")).thenReturn(dispatcher);
        spy.processRequest(request, response);
        when(context.getAttribute("mode")).thenReturn(DataType.FILE);
        spy.processRequest(request, response);
    }

    @Test
    public void testDoGet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        ServletContext context = mock(ServletContext.class);
        QuoteAndCategoryServlet instance = new QuoteAndCategoryServlet();
        QuoteAndCategoryServlet spy = spy(instance);
        doNothing().when(spy).processRequest(request, response);
        spy.doGet(request, response);
        verify(spy).processRequest(request, response);

    }

}
