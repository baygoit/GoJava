package ua.nenya.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.Before;
import org.mockito.Mockito;

import ua.nenya.dao.CategoryDao;
import ua.nenya.dao.QuoteDao;
import ua.nenya.domain.Category;
import ua.nenya.domain.Quote;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aplicationContextTest.xml" })
@WebAppConfiguration
public class CategoriesControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private QuoteDao quoteDao;

	@Test
	public void test() throws Exception {
		Quote quote = new Quote();
		quote.setId(1L);
		quote.setName("quote");
		
		when(quoteDao.getRandomQuote()).thenReturn(quote);
		
		Category categoryOne = new Category();
		categoryOne.setId(1L);
		categoryOne.setName("categoryOne");
		Category categoryTwo = new Category();
		categoryTwo.setId(2L);
		categoryTwo.setName("categoryTwo");
		
		when(categoryDao.getCategories()).thenReturn(Arrays.asList(categoryOne, categoryTwo));
		
		 mockMvc.perform(get("/"))
         .andExpect(status().isOk())
         .andExpect(view().name("categoriesPage"))
         .andExpect(forwardedUrl("/WEB-INF/views/categories.jsp"))
//         .andExpect(model().attribute("quote", hasItem(
//                 allOf(
//                         hasProperty("id", is(1L)),
//                         hasProperty("name", is("quote"))
//                 )
//         )))
//         .andExpect(model().attribute("categories", hasSize(2)))
//         .andExpect(model().attribute("categories", hasItem(
//                 allOf(
//                         hasProperty("id", is(1L)),
//                         hasProperty("description", is("Lorem ipsum")),
//                         hasProperty("title", is("Foo"))
//                 )
//         )))
//         .andExpect(model().attribute("categories", hasItem(
//                 allOf(
//                         hasProperty("id", is(2L)),
//                         hasProperty("description", is("Lorem ipsum")),
//                         hasProperty("title", is("Bar"))
//                 )
//         )));
         ;
		
		verify(quoteDao, times(1)).getRandomQuote();
        verifyNoMoreInteractions(quoteDao);
        
        verify(categoryDao, times(1)).getCategories();
        verifyNoMoreInteractions(categoryDao);
	}

}
