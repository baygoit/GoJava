package ua.goit.kyrychok.kickstarter;

import org.junit.Assert;
import org.junit.Test;
import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.model.Project;

import java.util.List;

public class DataProviderTest {

    @Test
    public void whenGetMsgThenReturnNotEmpty() throws Exception {
        DataProvider dataProvider = new DataProvider();

        String result = dataProvider.getWelcomeMessage();

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

    @Test
    public void whenRegisterCategoryThenReturnSameCategory() throws Exception {
        TestDataProvider testDataProvider = new TestDataProvider();
        testDataProvider.init();
        Category category = testDataProvider.getCategory(0);
        DataProvider dataProvider = new DataProvider();
        dataProvider.addCategory(category);

        Category result = dataProvider.getCategory(0);

        Assert.assertEquals("Category must be the same as registered", category, result);
    }

    @Test
    public void whenRegisterProjectThenReturnSameProject() throws Exception {
        TestDataProvider testDataProvider = new TestDataProvider();
        testDataProvider.init();
        DataProvider dataProvider = new DataProvider();
        dataProvider.setCategories(testDataProvider.getCategories());
        Project project = testDataProvider.getProject(0, 0);

        Project result = dataProvider.getProject(0, 0);

        Assert.assertEquals("Project must be the same as registered", project, result);
    }

}