package ua.goit.kyrychok.kickstarter.mvc.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.mvc.model.FaqModel;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

public class FaqViewTest {
    @Mock
    private FaqModel model;
    @Mock
    private Output output;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenRenderThenPrintInviteMessage() throws Exception {
        when(model.getInviteMessage()).thenReturn("Test Msg");

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

        FaqView faqView = new FaqView();
        faqView.setOutput(output);

        faqView.render(model);
        String[] expectedResult = {"Test Msg", BaseView.CHOICE_MESSAGE};
        Assert.assertArrayEquals("Not expected MainPage rendering", expectedResult, view.toArray());
    }

}