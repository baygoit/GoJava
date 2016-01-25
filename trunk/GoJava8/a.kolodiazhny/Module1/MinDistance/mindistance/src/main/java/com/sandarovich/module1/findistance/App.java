package com.sandarovich.module1.findistance;

/**
 * @author Olexander Kolodiazhny
 * 
 *         Module #1. Task #2
 *
 */
public class App {

    public static final int[] ARRAY = { 1, 5, 1, 4, 1, 0 };

    public static void main(String[] args) {
        MyArray array = new MyArray(ARRAY);
        System.out.println(array.getDistance());
    }
}
