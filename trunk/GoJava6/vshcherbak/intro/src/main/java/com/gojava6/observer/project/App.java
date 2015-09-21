package com.gojava6.observer.project;

//import java.util.Iterator;
//import java.util.ListIterator;

/**
 * Created by slavik on 21.09.2015.
 */
public class App {
    public static void main(String[] args) {
        Base base = new Base();
        User user = new Client("Name", "Surname", "email@site.com", "Kiev");
        base.add(user);
        user =  new Client("NameOne", "SurnameOne", "emailOne@site.com", "Kiev");
        base.add(user);
        user =  new Host("NameTwo", "SurnameTwo", "emailTwo@site.com");
        base.add(user);
        user =  new Host("NameThree", "SurnameThree", "emailThree@site.com");
        base.add(user);
        base.notifyAll("ready");
        base.remove("SurnameTwo");
        base.notifyAll("minus one");
    }
}
