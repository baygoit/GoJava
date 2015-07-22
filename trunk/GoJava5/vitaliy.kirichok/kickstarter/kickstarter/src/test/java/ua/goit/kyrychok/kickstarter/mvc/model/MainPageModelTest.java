package ua.goit.kyrychok.kickstarter.mvc.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.DataProvider;
import ua.goit.kyrychok.kickstarter.model.Category;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class MainPageModelTest {

    @Mock
    private DataProvider dataProvider;

    @InjectMocks
    private MainPageModel model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenGetMsgThenReturnNotNull() throws Exception {
        when(dataProvider.getWelcomeMessage()).thenReturn("Hello Msg");

        String result = model.getWelcomeMessage();

        Assert.assertNotNull("Hello msg must not be null", result);
        Assert.assertEquals("Hello Msg must be the same as in date registry", "Hello Msg", result);
    }

    @Test
    public void whenGetCategoriesThenReturnSameCategories() throws Exception {
        List<Category> expectedResult = new ArrayList<>();
        expectedResult.add(new Category("Category 1"));
        expectedResult.add(new Category("Category 2"));
        expectedResult.add(new Category("Category 3"));
        int expectedCount = expectedResult.size();
        when(dataProvider.getCategories()).thenReturn(expectedResult);

        model.update();
        List<Category> result = model.getCategories();
        int count = model.getCount();

        Assert.assertArrayEquals("Categories must be the same as registered", expectedResult.toArray(), result.toArray());
        Assert.assertEquals("getCount must return right result", expectedCount, count);
    }
}