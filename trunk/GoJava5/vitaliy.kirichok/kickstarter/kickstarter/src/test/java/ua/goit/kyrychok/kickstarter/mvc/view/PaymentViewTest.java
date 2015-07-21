package ua.goit.kyrychok.kickstarter.mvc.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import ua.goit.kyrychok.kickstarter.Output;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;

public class PaymentViewTest {

    @Mock
    private Output output;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenRenderThenPrintInviteMessage() throws Exception {
        final List<String> view = new ArrayList<>();

        doAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments();
                String str = (String) arguments[0];
                view.add(str);
                return null;
            }
        }).when(output).writeLine(anyString());
        PaymentView paymentView = new PaymentView();
        paymentView.setOutput(output);
        paymentView.render("Test invite message");

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Test invite message");
        Assert.assertArrayEquals("Not expected Payment rendering", expectedResult.toArray(), view.toArray());

    }
}