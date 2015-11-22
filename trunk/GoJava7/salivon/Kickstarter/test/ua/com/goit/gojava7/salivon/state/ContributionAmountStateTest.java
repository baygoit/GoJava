package ua.com.goit.gojava7.salivon.state;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Matchers;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import ua.com.goit.gojava7.salivon.util.ManagerData;
import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.context.Console;

public class ContributionAmountStateTest {

    @Test
    public void testOutputContentState() {
        Payment payment = mock(Payment.class);
        ContributionAmountState instance = new ContributionAmountState(payment);
        instance.outputContentState();
    }

    @Test
    public void testChangeState() {
        Console context = new Console();
        State.setCurrentData(State.FILE_DATA);
        Payment payment = mock(Payment.class);
        ContributionAmountState instance = new ContributionAmountState(payment);
        Project project = mock(Project.class);
        ManagerData md = mock(ManagerData.class);
        ContributionAmountState spy = spy(instance);
        when(spy.getManagerData()).thenReturn(md);
        when(spy.getInData()).thenReturn("1");
        when(md.getProject(anyInt())).thenReturn(project);
        spy.changeState(context);
    }

    @Test
    public void testSavePayment() {
        State.setCurrentData(State.FILE_DATA);
        Payment payment = mock(Payment.class);
        ContributionAmountState instance = new ContributionAmountState(payment);
        instance.savePayment(anyInt());
    }
}
