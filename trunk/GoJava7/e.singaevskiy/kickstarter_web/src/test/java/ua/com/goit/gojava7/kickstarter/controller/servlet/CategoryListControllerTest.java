package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class CategoryListControllerTest {

    @Mock
    private QuoteDAO quoteDAO;
    
    @Mock
    private CategoryDAO categoryDAO;
    
    @Mock
    private RequestDispatcher dispatcher;  
    
    @Mock
    private HttpServletRequest req;
    
    @Mock
    private HttpServletResponse resp;
    
    @Mock
    private ServletConfig config;
    
    @InjectMocks
    private CategoryListController servlet;
    
    @Before
    public void setUp() throws Exception {
    	Mockito.when(req.getRequestDispatcher(Mockito.anyString())).thenReturn(dispatcher);
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
        Mockito.verify(req).getRequestDispatcher("view/Categories.jsp");
        Mockito.verify(req).setAttribute("quote", quote);
        Mockito.verify(req).setAttribute("categories", cList);
        Mockito.verify(dispatcher).forward(req, resp);       
    }
    
    @Test
    public void testInit() throws Exception { 
    	ServletContext context = Mockito.mock(ServletContext.class);
		Mockito.when(config.getServletContext()).thenReturn(context);
    	StorageFactory storageFactory = Mockito.mock(StorageFactory.class);
		Mockito.when(context.getAttribute(ContextInitializer.STORAGE_FACTORY)).thenReturn(storageFactory);
    	
		servlet.init();      	
    	Mockito.verify(storageFactory).getQuoteDAO(); 
    	Mockito.verify(storageFactory).getCategoryDAO(); 
    }
}
