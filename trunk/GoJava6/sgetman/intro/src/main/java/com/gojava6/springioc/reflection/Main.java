package com.gojava6.springioc.reflection;

/**
 * Created by Jeka on 19/10/2014.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        MyService myService = ObjectFactory.createObject(MyService.class);
        System.out.println("myService = " + myService);
    }
}
