package ua.com.goit.gojava7.kickstarter.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.dao.QuestionsDAO;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;

@RunWith(MockitoJUnitRunner.class)
public class PaymentPageControllerTest {

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

    private long value;  
    
    @Before
    public void setUp() throws Exception {      
        
        when(factory.getQuestionsDAO()).thenReturn(questionsStorage);        
        when(factory.getPaymentDAO()).thenReturn(paymentStorage);
        value = 123L;
        when(paymentStorage.getSum(0)).thenReturn(value);
    
        controller = new PaymentPageController();
        controller.setInputReader(reader); 
        controller.setStorageFactory(factory);
        controller.setView(page);
        controller.setRequest(project);
    }
    
    @Test
    public void validPaymentRequest()  throws Exception {
        when(reader.readLine()).thenReturn("0 0 " + value);
        controller.dispatch();
        verify(page).showPaymentRequest();
        verify(project).setBalanceSum(value);
    }

}
