/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.adapter;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 12/7/15
 */
public class CarImpl implements Car {
    @Override
    public String getCarName() {
        return null;
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public String toString() {
        return getCarName() + " " + getColor();
    }
}
