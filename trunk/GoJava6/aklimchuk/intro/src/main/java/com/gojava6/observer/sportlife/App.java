package com.javarush.test.level13.lesson11.home07;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        Sportlife sportlife = new Sportlife();
        Client one = new Client();
        Client two = new Client();
        sportlife.register(one);
        sportlife.register(two);
        sportlife.notifyAllObservers();
    }
}
