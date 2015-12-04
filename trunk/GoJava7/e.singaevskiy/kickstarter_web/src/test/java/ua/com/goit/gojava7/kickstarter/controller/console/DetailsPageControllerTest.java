package ua.com.goit.gojava7.kickstarter.controller.console;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.controller.console.AbstractPageController;
import ua.com.goit.gojava7.kickstarter.controller.console.ProjectDetailsPageController;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.dao.QuestionsDAO;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;

@RunWith(MockitoJUnitRunner.class)
public class DetailsPageControllerTest {
    
    @Mock
    BufferedReader reader;
    
    @Mock
    PaymentDAO paymentStorage;
    
    @Mock
    QuestionsDAO questionsStorage;
    
    @Mock
    StorageFactory factory;
    
    @Mock
    ConsolePrinter page;
    
    AbstractPageController<Project> controller;
    
    @Mock
    Project project;  
    
    @Before
    public void setUp() throws Exception {      
        
        when(factory.getQuestionsDAO()).thenReturn(questionsStorage);        
        when(factory.getPaymentDAO()).thenReturn(paymentStorage);
        when(paymentStorage.getSum(0)).thenReturn(123L);
    
        controller = new ProjectDetailsPageController();
        controller.setInputReader(reader); 
        controller.setStorageFactory(factory);
        controller.setView(page);
        controller.setRequest(project);
    }

    @Test
    public void testPrintDetails()  throws Exception {
        when(reader.readLine()).thenReturn("0");
        controller.dispatch();
        verify(page).showProjectDetails(Matchers.eq(project));
    }

}
