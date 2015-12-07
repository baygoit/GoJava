package ua.com.goit.gojava7.salivon;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import org.mockito.Matchers;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.dao.DataType;

public class PaymentServletTest {

    @Test
    public void testProcessRequest() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        Payment payment = mock(Payment.class);
        HttpSession session = mock(HttpSession.class);
        ServletContext context = mock(ServletContext.class);
        PaymentServlet instance = new PaymentServlet();
        PaymentServlet spy = spy(instance);
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("name")).thenReturn("Ivan");
        when(request.getParameter("card")).thenReturn("125456464645");
        when(request.getParameter("total")).thenReturn("1256");
        when(session.getAttribute("idProject")).thenReturn(2);
        doNothing().when(spy).savePayment(Matchers.anyObject());
        spy.processRequest(request, response);
        verify(response).sendRedirect("project");
        verify(spy).savePayment(Matchers.any());
    }

    @Test
    public void testDoPost() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        ServletContext context = mock(ServletContext.class);
        PaymentServlet instance = new PaymentServlet();
        PaymentServlet spy = spy(instance);
        doNothing().when(spy).processRequest(request, response);
        spy.doPost(request, response);
        verify(spy).processRequest(request, response);

    }

    @Test
    public void testSavePayment() {
        ServletContext context = mock(ServletContext.class);
        Payment payment = mock(Payment.class);
        PaymentServlet instance = new PaymentServlet();
        PaymentServlet spy = spy(instance);
        doReturn(context).when(spy).getServletContext();
        when(context.getAttribute("mode")).thenReturn(DataType.FILE);
        spy.savePayment(payment);
        when(context.getAttribute("mode")).thenReturn(DataType.MEMORY);
        spy.savePayment(payment);

    }

}
