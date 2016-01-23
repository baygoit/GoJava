package com.kickstarter.beanVO;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PayerVo {
    @NotNull
    @Min(value = 0)
    @Digits(fraction = 0, integer = 6)
    @Pattern(regexp = "^[0-9]*$")
    private String paymentAmount;
    @Size(min = 3, max = 20)
    @Pattern(regexp = "^[A-Za-z]*$")
    @NotNull
    private String cardHolderName;

    @NotNull
    @Min(value = 0)
    @Digits(fraction = 0, integer = 12)
    @Pattern(regexp = "^[0-9]*$")
    private String cardNumber;

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

}
