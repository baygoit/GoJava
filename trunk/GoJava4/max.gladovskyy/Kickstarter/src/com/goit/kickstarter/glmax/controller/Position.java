package com.goit.kickstarter.glmax.controller;

public enum Position {
Main,
Category,
Project,
Question,
Payment;
private static Position[] vals = values();
public Position next()
{
    return vals[(this.ordinal()+1) % vals.length];
}
}
