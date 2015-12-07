package ua.com.goit.gojava7.kickstarter.controller.servlet;

import javax.servlet.RequestDispatcher;
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
    private HttpServletRequest req;
    
    @Mock
    private HttpServletResponse resp;
    
    @Mock
    private RequestDispatcher dispatcher;
    
    @InjectMocks
    private MessageController servlet;

	private String projectId;
    
    @Before
    public void setUp() throws Exception {
        projectId = "1";
		Mockito.when(req.getParameter("id")).thenReturn(projectId);
        Mockito.when(req.getRequestDispatcher(Mockito.anyString())).thenReturn(dispatcher);
    }

    @Test
    public void testDoGetHttpServletRequestHttpServletResponse() throws Exception {                 
        servlet.doGet(req, resp);
        Mockito.verify(req).getRequestDispatcher("view/Message.jsp?projectId="+projectId);
        Mockito.verify(dispatcher).forward(req, resp);           
    }
}
