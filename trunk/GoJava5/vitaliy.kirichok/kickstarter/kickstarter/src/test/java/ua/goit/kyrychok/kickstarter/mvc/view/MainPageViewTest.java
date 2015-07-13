package ua.goit.kyrychok.kickstarter.mvc.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.TestDataProvider;
import ua.goit.kyrychok.kickstarter.Utils;
import ua.goit.kyrychok.kickstarter.mvc.model.MainPageModel;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

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
    public void whenRenderMainPageThenPrintHelloMsgAndCategoriesList() throws Exception {
        when(model.getHelloMessage()).thenReturn("Test Msg");

        TestDataProvider testDataProvider = new TestDataProvider();
        testDataProvider.init();
        when(model.getCategories()).thenReturn(testDataProvider.getCategories());

        final List<String> view = new ArrayList<>();

        doAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments();
                String str = (String) arguments[0];
                view.add(str);
                return null;
            }
        }).when(output).writeLine(anyString());
        MainPageView mainPageView = new MainPageView(output);

        mainPageView.render(model);
        String[] expectedResult = {"Test Msg", "[1]. Category 1", "[2]. Category 2", "[3]. Category 3", Utils.CHOICE_MESSAGE};
        Assert.assertArrayEquals("Not expected MainPage rendering", expectedResult, view.toArray());
    }
}