package com.morkva.entities.utils;

import java.lang.annotation.Native;

/**
 * Created by vladyslav on 07.05.15.
 */
public class ID<T extends Number> implements Comparable<ID>{

    private final T value;

    public ID(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    @Override
    public int compareTo(ID o) {
        return (this.value.intValue() > o.value.intValue())?1:(value.intValue() < o.value.intValue())?-1:0;
    }
}
