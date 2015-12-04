package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class CategoryListTest {

    @Mock
    QuoteDAO quoteDAO;
    
    @Mock
    CategoryDAO categoryDAO;
    
    @Mock
    PrintWriter writer;   
    
    @Mock
    HttpServletRequest req;
    
    @Mock
    HttpServletResponse resp;
    
    @InjectMocks
    CategoryList servlet;
    
    @Before
    public void setUp() throws Exception {
        Mockito.when(resp.getWriter()).thenReturn(writer);
    }

    @Test
    public void testDoGetHttpServletRequestHttpServletResponse() throws Exception {   
        ArrayList<Quote> qList = new ArrayList<>();
        Quote quote = new Quote("q1", "q2");
        qList.add(quote);
        Mockito.when(quoteDAO.getAll()).thenReturn(qList);
        
        ArrayList<Category> cList = new ArrayList<>();
        cList.add(new Category(1, "c1"));
        cList.add(new Category(2, "c2"));
        Mockito.when(categoryDAO.getAll()).thenReturn(cList);
        
        servlet.doGet(req, resp);
        Mockito.verify(writer).print(Mockito.contains(quote.getText()));
        for (Category category : cList) {
            Mockito.verify(writer).print(Mockito.contains(category.getName()));
        }       
    }
}
