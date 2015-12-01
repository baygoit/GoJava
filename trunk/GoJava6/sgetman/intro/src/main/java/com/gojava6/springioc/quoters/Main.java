package com.gojava6.springioc.quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Jeka on 19/10/2014.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        System.out.println();
    }
}
