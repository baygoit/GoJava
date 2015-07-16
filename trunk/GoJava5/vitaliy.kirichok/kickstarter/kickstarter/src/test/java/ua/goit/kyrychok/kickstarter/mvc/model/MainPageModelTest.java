package ua.goit.kyrychok.kickstarter.mvc.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.DataProvider;
import ua.goit.kyrychok.kickstarter.TestDataProvider;
import ua.goit.kyrychok.kickstarter.model.Category;

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
        TestDataProvider testDataProvider = new TestDataProvider();
        testDataProvider.init();
        when(dataProvider.getCategories()).thenReturn(testDataProvider.getCategories());

        model.update();
        List<Category> result = model.getCategories();

        Assert.assertArrayEquals("Categories must be the same as registered", testDataProvider.getCategories().toArray(), result.toArray());
    }
}