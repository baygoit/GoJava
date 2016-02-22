package com.sandarovich.module1.numbersdivider;

/**
 * Input/output values
 */

public interface IO {
    void write(String message);

    String read();

    int parse(String value);
}
