package com.tyomsky.kickstarter.web.controller;

import com.tyomsky.kickstarter.domain.Category;
import com.tyomsky.kickstarter.domain.Quote;
import com.tyomsky.kickstarter.service.CategoryService;
import com.tyomsky.kickstarter.service.QuoteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-test-config/testContextForControllers.xml", "classpath:spring/spring-web-servlet.xml"})
@WebAppConfiguration
public class MainPageControllerTest {

    @Autowired private QuoteService quoteServiceMock;
    @Autowired private CategoryService categoryServiceMock;
    @Autowired private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        //We have to reset our mock between tests because the mock objects
        //are managed by the Spring container. If we would not reset them,
        //stubbing and verified behavior would "leak" from one test to another.
        Mockito.reset(quoteServiceMock);
        Mockito.reset(categoryServiceMock);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void index_ShouldAddQuoteAndAllCategoriesToModelAndRenderMainPageView() throws Exception {
        Quote quote = new Quote(1, "quote");

        Category category1 = new Category();
        category1.setId(1);
        category1.setName("category 1");

        Category category2 = new Category();
        category2.setId(2);
        category2.setName("category 2");

        when(quoteServiceMock.getRandomQuote()).thenReturn(quote);
        when(categoryServiceMock.getAllCategories()).thenReturn(Arrays.asList(category1, category2));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("mainPage"))
                .andExpect(model().attribute("quote", hasProperty("id", is(1))))
                .andExpect(model().attribute("quote", hasProperty("presentation", is("quote"))))
                .andExpect(model().attribute("categories", hasSize(2)))
                .andExpect(model().attribute("categories", hasItem(
                        allOf(
                                hasProperty("id", is(1)),
                                hasProperty("name", is("category 1"))
                        )
                )))
                .andExpect(model().attribute("categories", hasItem(
                        allOf(
                                hasProperty("id", is(2)),
                                hasProperty("name", is("category 2"))
                        )
                )));
        verify(quoteServiceMock, times(1)).getRandomQuote();
        verify(categoryServiceMock, times(1)).getAllCategories();
    }
}