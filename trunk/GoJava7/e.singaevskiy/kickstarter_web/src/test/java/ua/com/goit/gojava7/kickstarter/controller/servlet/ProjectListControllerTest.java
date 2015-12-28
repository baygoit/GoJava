package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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
import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@RunWith(MockitoJUnitRunner.class)
public class ProjectListControllerTest {

    @Mock
    private PaymentDAO paymentDAO;
    
    @Mock
    private ProjectDAO projectDAO;
    
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
    private ProjectListController servlet;

	private Category cathegory;
    
    @Before
    public void setUp() throws Exception {
    	Mockito.when(req.getRequestDispatcher(Mockito.anyString())).thenReturn(dispatcher);
        Mockito.when(req.getParameter("id")).thenReturn("1");
        Mockito.when(paymentDAO.getSum(Mockito.anyInt())).thenReturn(42L);
        cathegory = new Category(1, "cat1");
		Mockito.when(categoryDAO.get(Mockito.anyInt())).thenReturn(cathegory);     
    }

    @Test
    public void testDoGetHttpServletRequestHttpServletResponse() throws Exception {          
        
        ArrayList<Project> pList = new ArrayList<>();
        pList.add(new Project(1, "p1", "a1", null));
        pList.add(new Project(2, "p2", "a2", null));
        Mockito.when(projectDAO.getByCategory(Mockito.anyInt())).thenReturn(pList);
        
        servlet.doGet(req, resp);
        
        Mockito.verify(req).setAttribute("category", cathegory);
        Mockito.verify(req).setAttribute("projects", pList);
        Mockito.verify(req).getRequestDispatcher("view/ProjectList.jsp");
        Mockito.verify(dispatcher).forward(req, resp);
     
    }
    
    @Test
    public void testInit() throws Exception { 
/*    	ServletContext context = Mockito.mock(ServletContext.class);
		Mockito.when(config.getServletContext()).thenReturn(context);
    	StorageFactory storageFactory = Mockito.mock(StorageFactory.class);
		Mockito.when(context.getAttribute(ContextInitializer.STORAGE_FACTORY)).thenReturn(storageFactory);
    	
		servlet.init();      	
    	Mockito.verify(storageFactory).getProjectDAO(); 
    	Mockito.verify(storageFactory).getPaymentDAO(); 
    	Mockito.verify(storageFactory).getCategoryDAO();*/ 
    }
}
