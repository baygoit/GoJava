package ua.dborisenko.kickstarter;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.EmptyResultDataAccessException;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.dao.QuoteDao;
import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {

    @Mock
    private RequestDispatcher dispatcher;
    @Mock
    private ServletContext context;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private QuoteDao quoteDao;
    @Mock
    private CategoryDao categoryDao;
    @InjectMocks
    private CategoryController categoryController;

    @Before
    public void setUp() {
        when(request.getServletContext()).thenReturn(context);
        when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
    }

    @Test
    public void showCategoriesTest() throws ServletException, IOException {
        Quote quote = new Quote();
        when(quoteDao.getRandom()).thenReturn(quote);
        List<Category> categories = new ArrayList<>();
        when(categoryDao.getAll()).thenReturn(categories);
        categoryController.showCategories(request, response);
        verify(request).setAttribute(CategoryController.QUOTE_ATTR_NAME, quote);
        verify(request).setAttribute(CategoryController.CATEGORIES_ATTR_NAME, categories);
        verify(context).getRequestDispatcher(CategoryController.CATEGORIES_JSP_PATH);
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void showCategoryTest() throws ServletException, IOException {
        when(request.getParameter(CategoryController.ID_PARAM_NAME)).thenReturn("42");
        Category category = mock(Category.class);
        List<Project> projects = new ArrayList<>();
        when(category.getProjects()).thenReturn(projects);
        when(categoryDao.getWithProjects(42)).thenReturn(category);
        categoryController.showCategory(request, response);
        verify(request).setAttribute(CategoryController.CATEGORY_ATTR_NAME, category);
        verify(request).setAttribute(CategoryController.PROJECTS_ATTR_NAME, projects);
        verify(context).getRequestDispatcher(CategoryController.CATEGORY_JSP_PATH);
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void showCategoryEmptyTest() throws ServletException, IOException {
        when(request.getParameter(CategoryController.ID_PARAM_NAME)).thenReturn("42");
        when(categoryDao.getWithProjects(42)).thenThrow(new EmptyResultDataAccessException(1));
        categoryController.showCategory(request, response);
        verify(response).sendError(HttpServletResponse.SC_NOT_FOUND, ErrorText.CATEGORY_NOT_FOUND);
    }

    @Test
    public void showCategoryWrongNumberTest() throws ServletException, IOException {
        when(request.getParameter(CategoryController.ID_PARAM_NAME)).thenReturn("foo");
        categoryController.showCategory(request, response);
        verify(response).sendError(HttpServletResponse.SC_BAD_REQUEST, ErrorText.NUMBER_FORMAT);
    }
}
