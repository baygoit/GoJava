package ua.com.goit.java5.dm.kickstarter.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.com.goit.java5.dm.kickstarter.dao.CategoryDao;
import ua.com.goit.java5.dm.kickstarter.dao.QuoteDao;
import ua.com.goit.java5.dm.kickstarter.model.Category;
import ua.com.goit.java5.dm.kickstarter.model.Quote;
import ua.com.goit.java5.dm.kickstarter.mvc.ModelAndView;
import ua.com.goit.java5.dm.kickstarter.mvc.model.MainPageModel;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 8/12/15
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainPageControllerTest {

    @Mock
    private QuoteDao quoteDao;

    @Mock
    private CategoryDao categoryDao;

    @InjectMocks
    private MainPageController mainPageController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIndex() throws Exception {
        when(quoteDao.getQuote()).thenReturn(new Quote("Some quote", "Anonymous"));
        List<Category> categoriesList = createCategories();
        when(categoryDao.getAllCategories()).thenReturn(categoriesList);
        mainPageController.setView("view");

        ModelAndView modelAndView = mainPageController.index();
        MainPageModel mainPageModel = new MainPageModel(new Quote("Some quote", "Anonymous"), categoriesList);
        ModelAndView expected = new ModelAndView(mainPageModel, "view");

        assertEquals(expected, modelAndView);
    }

    private List<Category> createCategories() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Category 1"));
        categoryList.add(new Category("Category 2"));
        categoryList.add(new Category("Category 3"));
        return categoryList;
    }
}
