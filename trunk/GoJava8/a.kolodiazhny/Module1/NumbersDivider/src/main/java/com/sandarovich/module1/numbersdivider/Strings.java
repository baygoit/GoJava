package com.sandarovich.module1.numbersdivider;

/**
 * Constant holder
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

    Strings(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

