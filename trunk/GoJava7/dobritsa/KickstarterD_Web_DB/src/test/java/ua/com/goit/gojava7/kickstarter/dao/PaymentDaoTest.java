package ua.com.goit.gojava7.kickstarter.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.com.goit.gojava7.kickstarter.validator.MyValidator;
import ua.com.goit.gojava7.kickstarter.model.Project;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PaymentDaoTest {

    @Mock
    private MyValidator myValidator;

    @InjectMocks
    private PaymentDao paymentDao;

    @Test
    public void testCreateWrongPayment() {
        Project project = new Project();

        when(myValidator.validatePayer(anyObject(), anyObject())).thenReturn(false);

       // paymentDao.createPayment("V", "1111", 1L, project);

        verify(myValidator).validatePayer(any(String.class), any(String.class));
    }
}
