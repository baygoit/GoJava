package ua.com.goit.gojava7.kickstarter.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.model.Payment;
import ua.com.goit.gojava7.kickstarter.model.Project;

public class PaymentTest{
    Payment payment = new Payment();
    Project project = new Project();
    @Test
    public void testSetProject() {
        payment.setProject(project);
        assertThat(payment.getProject(), is(project));
    }

    @Test
    public void testSetCardOwner() {
        final String cardOwner = "Card Owner";
        payment.setCardOwner(cardOwner);
        assertThat(payment.getCardOwner().equals(cardOwner), is(true));
    }

    @Test
    public void testSetCardNumber() {
        final String cardNumber = "5000";
        payment.setCardNumber(cardNumber);
        assertThat(payment.getCardNumber(), is(cardNumber));
    }

    @Test
    public void testSetProjectId() {
        payment.setProjectId(150);
        assertThat(payment.getProjectId(), is(150));
    }

    @Test
    public void testSetAmount() {
        final String amount = "4321";
        payment.setAmount(amount);
        assertThat(payment.getAmount(), is(amount));
    }

    @Test
    public void testSetId() {
        payment.setId(12345);
        assertThat(payment.getId(), is(12345));
    }

}
