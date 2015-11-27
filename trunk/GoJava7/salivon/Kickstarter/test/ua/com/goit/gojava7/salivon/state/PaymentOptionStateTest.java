package ua.com.goit.gojava7.salivon.state;

import org.junit.Test;
import static org.mockito.Mockito.*;
import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.context.Console;
import ua.com.goit.gojava7.salivon.dao.DataType;

public class PaymentOptionStateTest {

    @Test
    public void testOutputContentState() {
        Payment payment = mock(Payment.class);
        PaymentOptionState instance = new PaymentOptionState(payment);
        instance.outputContentState();
    }

    @Test
    public void testChangeStateForFile() {
        State.setCurrentDataType(DataType.FILE);
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
    public void testSavePaymentForFile() {
        State.setCurrentDataType(DataType.FILE);
        int amount = 10;
        Payment payment = mock(Payment.class);
        PaymentOptionState instance = new PaymentOptionState(payment);
        instance.savePayment(amount);

    }

    @Test
    public void testChangeStateForMemory() {
        State.setCurrentDataType(DataType.MEMORY);
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
    public void testSavePaymentForMemory() {
        State.setCurrentDataType(DataType.MEMORY);
        int amount = 10;
        Payment payment = mock(Payment.class);
        PaymentOptionState instance = new PaymentOptionState(payment);
        instance.savePayment(amount);

    }

}
