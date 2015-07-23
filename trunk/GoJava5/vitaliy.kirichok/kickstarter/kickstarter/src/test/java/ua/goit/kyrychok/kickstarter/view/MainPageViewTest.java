package ua.goit.kyrychok.kickstarter.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.model.Category;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;

public class MainPageViewTest {


    //TODO @Mock
    //TODO private MainPageModel model;
    @Mock
    private Output output;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenRenderMainPageThenPrintWelcomeMsgAndCategoriesList() throws Exception {
        //TODO when(model.getWelcomeMessage()).thenReturn("Test Msg");

        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Category 1"));
        categories.add(new Category("Category 2"));
        categories.add(new Category("Category 3"));
        //TODO when(model.getCategories()).thenReturn(categories);

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
        MainPageView mainPageView = new MainPageView();
        mainPageView.setOutput(output);

        //TODO mainPageView.render(model);
        String[] expectedResult = {"Test Msg", "[1]. Category 1", "[2]. Category 2", "[3]. Category 3", BaseView.CHOICE_MESSAGE};
        Assert.assertArrayEquals("Not expected MainPage rendering", expectedResult, view.toArray());
    }
}