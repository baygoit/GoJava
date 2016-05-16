package com.sandarovich.kickstarter.service;


public class PaymentService {

    public static final int CARD_NUMBER_LENGTH = 11;


    public boolean allowPayment() {
        //TODO implement
//        String cardNumber = paymentDto.getCardNumber();
//        String cardHolder = paymentDto.getCardHolder();
//        double amount = paymentDto.getAmount();
//
//        return !(!StringUtils.isNumeric(cardNumber) || StringUtils.isNumericSpace(cardNumber)
//            || StringUtils.isEmpty(cardHolder) || amount <= 0 || cardNumber.length() != CARD_NUMBER_LENGTH);
        return true;
    }

}
