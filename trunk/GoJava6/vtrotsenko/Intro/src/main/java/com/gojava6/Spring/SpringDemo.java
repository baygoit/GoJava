package com.gojava6.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by root on 23.11.15.
 */
public class SpringDemo {
    public static Subject subject;

    static {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        subject = (TestSubject) context.getBean("subject");
    }

    public static void main(String[] args) {
        subject.notifyObservers();
    }
}
