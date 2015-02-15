package com.gojava.view;

public class MenuDownException extends Exception {
    private int detail;

    public MenuDownException(int a) {
        detail = a;
    }



    @Override
    public String toString() {
        return "You type " + detail
                + ". Not allowed to go up beyond the level of.";
    }
}
