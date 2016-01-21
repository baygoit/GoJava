package ua.com.goit.gojava7.kickstarter.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.servlet.ModelAndView;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.dto.CategoryDto;
import ua.com.goit.gojava7.kickstarter.dto.ProjectDto;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.ModelAndViewAssert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SpringBeanAutowiringSupport.class)
public class CategoryControllerTest {

    @Mock
    private QuoteDao quoteDao;
    @Mock
    private CategoryDao categoryDao;
    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @Test
    public void testShowCategories() {
        Quote quote = new Quote();
        when(quoteDao.getRandomQuote()).thenReturn(quote);



        CategoryDto categoryDto = new CategoryDto();
        List<CategoryDto> categories = new ArrayList<>();
        categories.add(categoryDto);
        when(categoryService.getAll()).thenReturn(categories);

        ModelAndView modelAndView = categoryController.showCategories();

        assertViewName(modelAndView, "index");
        assertModelAttributeValue(modelAndView,  "quote", quote);
        assertCompareListModelAttribute(modelAndView, "categories", categories);
    }

    @Test
    public void testShowCategory() {

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(11L);
        categoryDto.setName("TestCategoryDto");

        ProjectDto projectDto = new ProjectDto();
        List<ProjectDto> projactsDto = new ArrayList<>();
        projactsDto.add(projectDto);

        categoryDto.setProjects(projactsDto);

        when(categoryService.get(anyLong())).thenReturn(categoryDto);

        ModelAndView modelAndView = categoryController.showCategory(11L);

        assertViewName(modelAndView, "category");
        assertModelAttributeValue(modelAndView,  "categoryName", "TestCategoryDto");
        assertCompareListModelAttribute(modelAndView, "projects", projactsDto);
    }
}
