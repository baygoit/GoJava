package com.gojava6.springioc.quoters;

/**
 * Created by Jeka on 19/10/2014.
 */
public class ShakespearQuoter implements Quoter {
    private String message;


    @EnvParam("repeat")
    private int repeat;

    public ShakespearQuoter(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
