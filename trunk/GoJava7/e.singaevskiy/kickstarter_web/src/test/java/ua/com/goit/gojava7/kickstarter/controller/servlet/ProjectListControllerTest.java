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
    private PrintWriter writer;   
    
    @Mock
    private HttpServletRequest req;
    
    @Mock
    private HttpServletResponse resp;
    
    @InjectMocks
    private ProjectListController servlet;
    
    @Before
    public void setUp() throws Exception {
        Mockito.when(resp.getWriter()).thenReturn(writer);
        Mockito.when(req.getParameter("id")).thenReturn("1");
        Mockito.when(paymentDAO.getSum(Mockito.anyInt())).thenReturn(42L);
        Mockito.when(categoryDAO.get(Mockito.anyInt())).thenReturn(new Category(1, "cat1"));     
    }

    @Test
    public void testDoGetHttpServletRequestHttpServletResponse() throws Exception {          
        
        ArrayList<Project> pList = new ArrayList<>();
        pList.add(new Project(1, "p1", "a1", 1));
        pList.add(new Project(2, "p2", "a2", 1));
        Mockito.when(projectDAO.getByCategory(Mockito.anyInt())).thenReturn(pList);
        
        servlet.doGet(req, resp);
        for (Project project : pList) {
            Mockito.verify(writer).print(Mockito.contains(project.getName()));
        }       
    }
}
