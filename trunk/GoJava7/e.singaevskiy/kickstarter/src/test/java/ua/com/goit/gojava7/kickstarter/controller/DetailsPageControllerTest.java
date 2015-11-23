package ua.com.goit.gojava7.kickstarter.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.PaymentStorage;
import ua.com.goit.gojava7.kickstarter.dao.QuestionsStorage;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.view.MainPage;

@RunWith(MockitoJUnitRunner.class)
public class DetailsPageControllerTest {
    
    @Mock
    BufferedReader reader;
    
    @Mock
    PaymentStorage paymentStorage;
    
    @Mock
    QuestionsStorage questionsStorage;
    
    @Mock
    StorageFactory factory;
    
    @Mock
    MainPage page;
    
    PageController<Project> controller;
    
    @Mock
    Project project;  
    
    @Before
    public void setUp() throws Exception {      
        
        when(factory.getQuestionsDAO()).thenReturn(questionsStorage);
        
        when(factory.getPaymentDAO()).thenReturn(paymentStorage);
        when(paymentStorage.getSum(project)).thenReturn(123L);
    
        controller = new ProjectDetailsPageController();
        controller.setInputReader(reader); 
        controller.setStorageFactory(factory);
        controller.setMainPage(page);
        controller.setRequest(project);
    }

    @Test
    public void testPrintDetails()  throws Exception {
        when(reader.readLine()).thenReturn("0");
        controller.dispatch();
        verify(page).showProjectDetails(Matchers.eq(project));
    }

}
