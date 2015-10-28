package ua.com.goit.java5.dm.kickstarter.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import ua.com.goit.java5.dm.kickstarter.model.Category;
import ua.com.goit.java5.dm.kickstarter.model.Quote;
import ua.com.goit.java5.dm.kickstarter.mvc.ModelAndView;
import ua.com.goit.java5.dm.kickstarter.mvc.controller.MainPageController;
import ua.com.goit.java5.dm.kickstarter.mvc.model.MainPageModel;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyObject;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 8/12/15
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainPageServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private MainPageController mainPageController;

    @Mock
    private RequestDispatcher requestDispatcher;

    @InjectMocks
    private MainPageServlet mainPageServlet;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoGet() throws Exception {
        final Map<String, Object> attributes = new HashMap<>();
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                attributes.put(invocation.getArgumentAt(0, String.class), invocation.getArgumentAt(1, Object.class));
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        }).when(request).setAttribute(anyString(), anyObject());
        when(mainPageController.index()).thenReturn(new ModelAndView(new MainPageModel(new Quote(), new ArrayList<Category>()), "view"));
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        mainPageServlet.doGet(request, response);

        Object actual = attributes.get("model");
        assertNotNull("Attribute 'model' must not be null", actual);
        assertTrue(actual instanceof MainPageModel);
        verify(requestDispatcher, times(1)).forward(request, response);
    }
}
