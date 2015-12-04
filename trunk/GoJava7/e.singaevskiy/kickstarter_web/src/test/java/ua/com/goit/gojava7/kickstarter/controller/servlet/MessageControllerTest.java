package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MessageControllerTest {
    
    @Mock
    private PrintWriter writer;   
    
    @Mock
    private HttpServletRequest req;
    
    @Mock
    private HttpServletResponse resp;
    
    @InjectMocks
    private MessageController servlet;
    
    @Before
    public void setUp() throws Exception {
        Mockito.when(resp.getWriter()).thenReturn(writer);
        Mockito.when(req.getParameter("id")).thenReturn("1");   
    }

    @Test
    public void testDoGetHttpServletRequestHttpServletResponse() throws Exception {          
        
        servlet.doGet(req, resp);
        Mockito.verify(writer).print(Mockito.contains("projectId"));
        Mockito.verify(writer).print(Mockito.contains("message"));
              
    }
}
