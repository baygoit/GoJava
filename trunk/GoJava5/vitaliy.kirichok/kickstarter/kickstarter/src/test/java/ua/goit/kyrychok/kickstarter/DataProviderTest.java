package ua.goit.kyrychok.kickstarter;

import org.junit.Assert;
import org.junit.Test;
import ua.goit.kyrychok.kickstarter.model.Category;

import java.util.List;

public class DataProviderTest {

    @Test
    public void whenGetMsgThenReturnNotEmpty() throws Exception {
        DataProvider dataProvider = new DataProvider();

        String result = dataProvider.getHelloMessage();

        Assert.assertNotNull("Hello message must be not null", result);
        Assert.assertTrue("Hello message must be not empty", result.trim().length() > 0);
    }

    @Test
    public void whenRegisterCategoriesThenReturnSameCategories() throws Exception {
        TestDataProvider testDataProvider = new TestDataProvider();
        testDataProvider.init();
        DataProvider dataProvider = new DataProvider();
        dataProvider.setCategories(testDataProvider.getCategories());

        List<Category> result = dataProvider.getCategories();

        Assert.assertArrayEquals("Categories must be the same as registered", testDataProvider.getCategories().toArray(), result.toArray());
    }

}