package ua.com.goit.gojava7.salivon.state;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Matchers;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.context.Console;
import ua.com.goit.gojava7.salivon.dao.DataType;

public class ContributionAmountStateTest {

    @Test
    public void testOutputContentState() {
        Payment payment = mock(Payment.class);
        ContributionAmountState instance = new ContributionAmountState(payment);
        instance.outputContentState();
    }

    @Test
    public void testValidate() {
        Payment payment = mock(Payment.class);
        ContributionAmountState instance = new ContributionAmountState(payment);
        assertEquals(true, instance.validate("1"));
        assertEquals(false, instance.validate("1df"));
    }

    @Test
    public void testChangeStateForFile() {
        Console context = new Console();
        State.setCurrentDataType(DataType.FILE);
        Payment payment = mock(Payment.class);
        ContributionAmountState instance = new ContributionAmountState(payment);
        Project project = mock(Project.class);
        ContributionAmountState spy = spy(instance);
        when(spy.getInData()).thenReturn("1");
        spy.changeState(context);
    }

    @Test
    public void testSavePaymentForFile() {
        State.setCurrentDataType(DataType.FILE);
        Payment payment = mock(Payment.class);
        ContributionAmountState instance = new ContributionAmountState(payment);
        instance.savePayment(anyInt());
    }

    @Test
    public void testChangeStateForMemory() {
        Console context = new Console();
        State.setCurrentDataType(DataType.MEMORY);
        Payment payment = mock(Payment.class);
        ContributionAmountState instance = new ContributionAmountState(payment);
        Project project = mock(Project.class);
        ContributionAmountState spy = spy(instance);
        when(spy.getInData()).thenReturn("1");
        spy.changeState(context);
    }

    @Test
    public void testSavePaymentForMemory() {
        State.setCurrentDataType(DataType.MEMORY);
        Payment payment = mock(Payment.class);
        ContributionAmountState instance = new ContributionAmountState(payment);
        instance.savePayment(anyInt());
    }
}
