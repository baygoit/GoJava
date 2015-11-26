package com.gojava6.differenttasks.pattern.observer.posttask;

/**
 * @Autor Andrey Chaykin
 * @Since 26.09.2015
 */
public class Application {

    public static void main(String[] args) {
        PostOffice postOffice = new PostOffice("first postOffice");
        MailBox mailBox1 = new MailBox1(postOffice);
        MailBox mailBox2 = new MailBox2(postOffice);
        MailBox mailBox3 = new MailBox3(postOffice);

        postOffice.addObserver(mailBox1);
        postOffice.addObserver(mailBox2);

        mailBox1.printMessage();

        postOffice.sendMessage("Hi! Lets create something wonderful in this world!");

        mailBox1.printMessage();
        mailBox2.printMessage();
        mailBox3.printMessage();

        postOffice.addObserver(mailBox3);

        postOffice.sendMessage("Frank Sinatra was a good guy");

        mailBox1.printMessage();
        mailBox2.printMessage();
        mailBox3.printMessage();



    }
}
