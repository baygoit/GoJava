package ua.com.goit.gojava7.salivon.state;

import org.junit.Test;
import static org.mockito.Mockito.*;
import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.context.Console;

public class PaymentOptionStateTest {

    @Test
    public void testOutputContentState() {
        Payment payment = mock(Payment.class);
        PaymentOptionState instance = new PaymentOptionState(payment);
        instance.outputContentState();
    }

    @Test
    public void testChangeState() {
        State.setCurrentData(State.FILE_DATA);
        Payment payment = mock(Payment.class);
        Console context = new Console();
        PaymentOptionState instance = new PaymentOptionState(payment);
        PaymentOptionState spy = spy(instance);
        when(spy.getInData()).thenReturn("1");
        spy.changeState(context);
        when(spy.getInData()).thenReturn("2");
        spy.changeState(context);
        when(spy.getInData()).thenReturn("3");
        spy.changeState(context);
        when(spy.getInData()).thenReturn("4");
        spy.changeState(context);
        when(spy.getInData()).thenReturn("5");
        spy.changeState(context);
    }

    @Test
    public void testSavePayment() {
        int amount = 10;
        Payment payment = mock(Payment.class);
        PaymentOptionState instance = new PaymentOptionState(payment);
        instance.savePayment(amount);

    }

}
