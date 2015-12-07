package ua.com.goit.gojava7.salivon;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ua.com.goit.gojava7.salivon.dao.DataType;

public class FaqServletTest {

    @Test
    public void testProcessRequest() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FaqServlet instance = new FaqServlet();
        FaqServlet spy = spy(instance);
        doNothing().when(spy).saveFaq(request);
        spy.processRequest(request, response);
        verify(response).sendRedirect("project");
        verify(spy).saveFaq(request);
    }

    @Test
    public void testDoPost() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        ServletContext context = mock(ServletContext.class);
        FaqServlet instance = new FaqServlet();
        FaqServlet spy = spy(instance);
        doNothing().when(spy).processRequest(request, response);
        spy.doPost(request, response);
        verify(spy).processRequest(request, response);
    }

    @Test
    public void testSaveFaq() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        ServletContext context = mock(ServletContext.class);
        FaqServlet instance = new FaqServlet();
        FaqServlet spy = spy(instance);
        doReturn(context).when(spy).getServletContext();
        when(context.getAttribute("mode")).thenReturn(DataType.FILE);
        when(request.getParameter("id")).thenReturn("1");
        spy.saveFaq(request);
        when(context.getAttribute("mode")).thenReturn(DataType.MEMORY);
        spy.saveFaq(request);

    }

}
