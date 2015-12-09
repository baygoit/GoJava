/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.adapter;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 12/7/15
 */
public class TreeImpl implements Tree {
    @Override
    public String toString() {
        return getName() + " " + getTreeColor();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getTreeColor() {
        return null;
    }
}
