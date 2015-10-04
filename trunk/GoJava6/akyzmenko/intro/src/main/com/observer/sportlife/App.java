package com.observer.sportlife;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Sportlife sportlife = new Sportlife();
        Observer one = new Client();
        Observer two = new Client();
        sportlife.register(one);
        sportlife.register(two);
        sportlife.notifyAllObservers();
    }
}
