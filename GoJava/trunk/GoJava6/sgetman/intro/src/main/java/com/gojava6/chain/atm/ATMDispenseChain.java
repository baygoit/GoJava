/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.chain.atm;

import java.util.Scanner;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 10/31/15
 */
public class ATMDispenseChain {

    private DispenseChain c1;

    public ATMDispenseChain() {
        // initialize the chain
        this.c1 = new DispenseChain();
        c1.setAmount(50);
        DispenseChain c2 = new DispenseChain();
        c2.setAmount(20);
        DispenseChain c3 = new DispenseChain();
        c3.setAmount(10);

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            // process the request
            atmDispenser.c1.dispense(new Currency(amount));
        }

    }

}
