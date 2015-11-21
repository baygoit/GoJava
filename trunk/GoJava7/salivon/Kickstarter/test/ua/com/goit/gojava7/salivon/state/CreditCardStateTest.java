package ua.com.goit.gojava7.salivon.state;

import org.junit.Test;
import static org.mockito.Mockito.*;
import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.context.Console;

public class CreditCardStateTest {

    @Test
    public void testOutputContentState() {
        Payment payment = mock(Payment.class);
        CreditCardState instance = new CreditCardState(payment);
        instance.outputContentState();

    }

    @Test
    public void testChangeState() {
        Console context = mock(Console.class);
        Payment payment = mock(Payment.class);
        CreditCardState instance = new CreditCardState(payment);
        CreditCardState spy = spy(instance);
        when(spy.getInData()).thenReturn("100");
        spy.changeState(context);
        verify(context).setCurrentState(anyObject());
    }

}
