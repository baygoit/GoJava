package ua.goit.kyrychok.kickstarter.view;

import org.junit.Assert;
import org.junit.Test;
import ua.goit.kyrychok.kickstarter.ConsoleOutput4Test;
import ua.goit.kyrychok.kickstarter.StandByMode;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static ua.goit.kyrychok.kickstarter.view.BaseView.CHOICE_MESSAGE_SHORT;

public class PaymentViewTest {
    private ConsoleOutput4Test output = new ConsoleOutput4Test();

    @Test
    public void whenRenderThenPrintInviteMessage4UserName() throws Exception {
        PaymentView paymentView = new PaymentView(output);
        paymentView.render(StandByMode.EXPECTED_USER_NAME);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(format("Enter user name(%s): ", CHOICE_MESSAGE_SHORT));
        Assert.assertArrayEquals("Not expected Payment rendering", expectedResult.toArray(), output.getResult().toArray());
    }

    @Test
    public void whenRenderThenPrintInviteMessage4CardNo() throws Exception {
        PaymentView paymentView = new PaymentView(output);
        paymentView.render(StandByMode.EXPECTED_CARD_NO);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(format("Enter card number(%s): ", CHOICE_MESSAGE_SHORT));
        Assert.assertArrayEquals("Not expected Payment rendering", expectedResult.toArray(), output.getResult().toArray());
    }

    @Test
    public void whenRenderThenPrintInviteMessage4Amount() throws Exception {
        PaymentView paymentView = new PaymentView(output);
        paymentView.render(StandByMode.EXPECTED_AMOUNT);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(format("Enter pledge amount(%s): ", CHOICE_MESSAGE_SHORT));
        Assert.assertArrayEquals("Not expected Payment rendering", expectedResult.toArray(), output.getResult().toArray());
    }
}