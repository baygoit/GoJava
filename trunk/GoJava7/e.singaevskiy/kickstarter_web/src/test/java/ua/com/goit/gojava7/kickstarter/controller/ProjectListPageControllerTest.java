package ua.com.goit.gojava7.kickstarter.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.controller.console.AbstractPageController;
import ua.com.goit.gojava7.kickstarter.controller.console.ProjectListPageController;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;

@RunWith(MockitoJUnitRunner.class)
public class ProjectListPageControllerTest {

    @Mock
    BufferedReader reader;
    
    @Mock
    PaymentDAO paymentStorage;
    
    @Mock
    ProjectDAO projectDAO;
    
    @Mock
    StorageFactory factory;
    
    @Mock
    ConsolePrinter printer;
    
    AbstractPageController<Category> controller;
    
    @Mock
    Category request;

    private ArrayList<Project> projects;  
    
    @Before
    public void setUp() throws Exception {      
        projects = new ArrayList<>();
        projects.add(new Project());
        when(factory.getProjectDAO()).thenReturn(projectDAO);
        when(projectDAO.getByCategory(0)).thenReturn(projects);
        when(factory.getPaymentDAO()).thenReturn(paymentStorage);
        when(paymentStorage.getSum(0)).thenReturn(123L);
    
        controller = new ProjectListPageController();
        controller.setInputReader(reader); 
        controller.setStorageFactory(factory);
        controller.setView(printer);
        controller.setRequest(request);
    }

    @Test
    public void showProjects()  throws Exception {
        when(reader.readLine()).thenReturn("0");
        controller.dispatch();
        verify(printer).showProjects(Matchers.eq(projects));
    }

}
