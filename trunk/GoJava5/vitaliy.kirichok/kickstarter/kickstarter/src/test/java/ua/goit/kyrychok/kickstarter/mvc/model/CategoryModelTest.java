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
import ua.goit.kyrychok.kickstarter.model.Project;

import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class CategoryModelTest {

    @Mock
    private DataProvider dataProvider;

    @InjectMocks
    private CategoryModel model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenUpdateThenReturnSameCategory() throws Exception {
        TestDataProvider testDataProvider = new TestDataProvider();
        testDataProvider.init();
        Category category = testDataProvider.getCategory(0);
        when(dataProvider.getCategory(anyInt())).thenReturn(category);

        model.update();
        List<Project> resultProjects = model.getProjects();
        String resultName = model.getName();

        Assert.assertArrayEquals("Projects must be the same as registered", category.getProjects().toArray(), resultProjects.toArray());
        Assert.assertEquals("Category name must be the same as registered", category.getName(), resultName);
    }


}