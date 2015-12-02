package com.gojava6.springioc.reflection;

/**
 * Created by Jeka on 19/10/2014.
 */
public class MyService {
    @RunThisMethod(repeat = 5)
    public void doWork(){
        System.out.println("Mi rabotaem s reflection");
    }

    @Override
    public String toString() {
        return "java 8";
    }
}
