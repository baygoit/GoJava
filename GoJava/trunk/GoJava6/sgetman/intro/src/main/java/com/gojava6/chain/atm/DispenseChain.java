/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.chain.atm;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 10/31/15
 */
public class DispenseChain {
    private int amount;

    private DispenseChain chain;

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setNextChain(DispenseChain nextChain) {
        chain = nextChain;
    }

    public void dispense(Currency cur) {
        if(cur.getAmount() >= amount){
            int num = cur.getAmount()/ amount;
            int remainder = cur.getAmount() % amount;
            System.out.println("Dispensing "+num+" " + amount + "$ note");
            if(remainder !=0) this.chain.dispense(new Currency(remainder));
        }else{
            this.chain.dispense(cur);
        }
    }
}
