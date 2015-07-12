package goit.dm.kickstarter.mvc.view;

import goit.dm.kickstarter.mvc.view.MainPageView;
import goit.dm.kickstarter.Output;
import goit.dm.kickstarter.model.Category;
import goit.dm.kickstarter.mvc.model.MainPageModel;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainPageViewTest {
    
    @Mock
    private MainPageModel model;

    @Mock
    private Output output;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenRenderMainPageThanPrintHelloMsgAndCategoriesList() throws Exception {
        when(model.getHelloMsg()).thenReturn("Test Msg");
        Category[] category = {new Category("Category 1"), new Category("Category 2"), new Category("Category 3")};
        when(model.getCategories()).thenReturn(category);

        final List<String> view = new ArrayList<String>();

        // Here we mock output.println() to store received argument in List of Strings
        // so than we can compare it with expected result
        doAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments();
                String str = (String) arguments[0];
                view.add(str);
                return null;
            }}).when(output).println(anyString()); // here we use anyString matcher so this mocked method
                                                   // will be call with any string passed to println method
        MainPageView mainPageView = new MainPageView(output);

        mainPageView.render(model);
        String[] expectedResult = {"Test Msg", "1 Category 1", "2 Category 2", "3 Category 3"};
        Assert.assertArrayEquals(expectedResult, view.toArray());
    }
}
