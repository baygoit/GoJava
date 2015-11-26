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

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;

@RunWith(MockitoJUnitRunner.class)
public class WelcomePageControllerTest {
    
    @Mock
    BufferedReader reader;
    
    @Mock
    QuoteDAO quotesStorage;
    
    @Mock
    CategoryDAO catStorage;
    
    @Mock
    ProjectDAO projectStorage;
    
    @Mock
    StorageFactory factory;
    
    @Mock
    ConsolePrinter page;
    
    @SuppressWarnings("rawtypes")
    AbstractPageController controller;

    private List<Category> cats;

    private ArrayList<Project> projects;
    
    @Before
    public void setUp() throws Exception {
        List<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote("a1", "q1"));
        quotes.add(new Quote("a2", "q2"));

        when(factory.getQuoteDAO()).thenReturn(quotesStorage);
        when(quotesStorage.getAll()).thenReturn(quotes);
        
        cats = new ArrayList<>();
        cats.add(new Category(1, "c1"));
        cats.add(new Category(2, "c2"));
        
        when(factory.getCategoryDAO()).thenReturn(catStorage);
        when(catStorage.getAll()).thenReturn(cats);
        
        when(factory.getProjectDAO()).thenReturn(projectStorage);
        projects = new ArrayList<>();
        when(projectStorage.getAll()).thenReturn(projects);
    
        controller = new WelcomePageController();
        controller.setInputReader(reader); 
        controller.setStorageFactory(factory);
        controller.setView(page);
        
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
    
    @Test
    public void testPageProjectsByCat()  throws Exception {
        when(reader.readLine()).thenReturn("1", "0");
        controller.dispatch();
        verify(page).showProjects(Matchers.eq(projects));
    }

}
