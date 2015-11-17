/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.chain.atm;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 10/31/15
 */
public class Currency {

    private int amount;

    public Currency(int amt){
        this.amount=amt;
    }

    public int getAmount(){
        return this.amount;
    }
}


