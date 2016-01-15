package ua.com.goit.gojava7.kickstarter.payment;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class PaymentSystemTest{
    PaymentSystem paymentSystem = new PaymentSystem();
    @Test
    public void testSetPaymentSystemName() {
       final String paymentSystemName = "paymentSystemName";
    paymentSystem.setPaymentSystemName(paymentSystemName);
    assertThat(paymentSystem.getPaymentSystemName().equals(paymentSystemName), is(true));
    }

    @Test
    public void testSetPaymentSystemID() {
       paymentSystem.setPaymentSystemID(900);
       assertThat(paymentSystem.getPaymentSystemID(), is(900));
    }

}
