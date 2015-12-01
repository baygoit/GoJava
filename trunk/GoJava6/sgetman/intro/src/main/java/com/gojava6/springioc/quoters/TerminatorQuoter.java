package com.gojava6.springioc.quoters;

import java.util.List;

/**
 * Created by Jeka on 19/10/2014.
 */
public class TerminatorQuoter implements Quoter {
    private List<String> messages;

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public void sayQuote() {
        for (String message : messages) {
            System.out.println("message = " + message);
        }
    }
}
