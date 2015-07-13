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
import ua.goit.kyrychok.kickstarter.mvc.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

public class CategoryViewTest {

    @Mock
    private CategoryModel model;
    @Mock
    private Output output;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenRenderCategoryThenPrintNameAndProjectsList() throws Exception {
        when(model.getName()).thenReturn("Test Category");

        TestDataProvider testDataProvider = new TestDataProvider();
        testDataProvider.init();
        when(model.getProjects()).thenReturn(testDataProvider.getProjects(0));

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
        CategoryView categoryView = new CategoryView(output);

        categoryView.render(model);
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Test Category");
        expectedResult.add("[1]. 1st project");
        expectedResult.add("     Short Description: desc");
        expectedResult.add("     Goal: 100,00");
        expectedResult.add("     Balance: 3500,00");
        expectedResult.add("     18 days to go");
        expectedResult.add("[2]. 2nd project");
        expectedResult.add("     Short Description: desc");
        expectedResult.add("     Goal: 100,00");
        expectedResult.add("     Balance: 3500,00");
        expectedResult.add("     18 days to go");
        expectedResult.add(Utils.CHOICE_MESSAGE);
        Assert.assertArrayEquals("Not expected Category rendering", expectedResult.toArray(), view.toArray());
    }
}