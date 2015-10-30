package com.shcherbak;

import com.shcherbak.common.Observer;
import com.shcherbak.common.Processor;

import java.util.List;

public class Registration implements Observer {
    private List<String> notify;
    private Processor processor;

    public Registration(Processor processor) {
        this.processor = processor;
    }

    public void addToNotify (int user_id) {
        processor.setNotify(user_id);
    }

    public void removeFromNotify (int user_id) {
       processor.unSetNotify(user_id);
    }

    public void notifyAll(String data) {
        notify = processor.getNotifyEmails("All");
        for (String send: notify) {
            System.out.println("Send " + data + " to " + send);
        }
    }

    public void notifyHosts(String data) {
        notify = processor.getNotifyEmails("host");
        for (String send: notify) {
            System.out.println("Send " + data + " to " + send);
        }
    }

    public void notifyClients(String data) {
        notify = processor.getNotifyEmails("client");
        for (String send: notify) {
            System.out.println("Send " + data + " to " + send);
        }
    }

    public void update(String message) {
        notify = processor.getNotifyEmails("notify");
        for (String send: notify) {
            System.out.println("Send " + message + " to " + send);
        }
    }
}
