package com.gojava6;

import java.util.function.BinaryOperator;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 12/9/15
 */
@FunctionalInterface
public interface ArithmeticalInterface<T> {
    T apply(T a, T b, BinaryOperator<T> operator);
}
