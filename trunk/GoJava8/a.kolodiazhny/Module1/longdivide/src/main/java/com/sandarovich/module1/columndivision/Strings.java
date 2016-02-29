package com.sandarovich.module1.columndivision;

/**
 * @author Olexander Kolodiazhny 2016
 */

public enum Strings {
    
    COLUMN_DIVIDER("|"),
    OPERATION_DIVIDER("---"),
    OPERATION_MINUS("-"),
    SPACE(" "),
    BRACKET_LEFT("("),
    BRACKET_RIGHT(")"),
    TAB("  "),
    DIVIDER("/");
    
    private final String text;
    
    private Strings(final String text) {
        this.text = text;
    }
    
    @Override
    public String toString() {
        return text;
    }
}
