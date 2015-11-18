package ua.com.goit.gojava7.kickstarter.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.DataStorage;
import ua.com.goit.gojava7.kickstarter.dao.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.view.MainPage;

@RunWith(MockitoJUnitRunner.class)
public class WelcomePageControllerTest {
    
    @Mock
    BufferedReader reader;
    
    @Mock
    DataStorage<Quote> quotesStorage;
    
    @Mock
    DataStorage<Category> catStorage;
    
    @Mock
    ProjectStorage projectStorage;
    
    @Mock
    StorageFactory factory;
    
    @Mock
    MainPage page;
    
    @SuppressWarnings("rawtypes")
    PageController controller;

    private List<Category> cats;
    
    @Before
    public void setUp() throws Exception {
        List<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote("a1", "q1"));
        quotes.add(new Quote("a2", "q2"));

        when(factory.getQuoteDAO()).thenReturn(quotesStorage);
        when(quotesStorage.getAll()).thenReturn(quotes);
        
        cats = new ArrayList<>();
        cats.add(new Category("c1"));
        cats.add(new Category("c2"));
        
        when(factory.getCategoryDAO()).thenReturn(catStorage);
        when(catStorage.getAll()).thenReturn(cats);
        
        when(factory.getProjectDAO()).thenReturn(projectStorage);
        when(projectStorage.getAll()).thenReturn(new ArrayList<>());
    
        controller = new WelcomePageController();
        controller.setInputReader(reader); 
        controller.setStorageFactory(factory);
        controller.setMainPage(page);
        
    }

    @Test
    public void testRandomQuote() throws Exception {      
        when(reader.readLine()).thenReturn("0");
        controller.dispatch();
        verify(page).showQuote(any(Quote.class));
    }
    
    @Test
    public void testPrintCategories()  throws Exception {
        when(reader.readLine()).thenReturn("0");
        controller.dispatch();
        verify(page).showCategories(Matchers.eq(cats));
    }

}
