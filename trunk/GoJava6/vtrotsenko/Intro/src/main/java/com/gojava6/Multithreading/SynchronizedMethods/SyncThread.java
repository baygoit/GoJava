package com.gojava6.Multithreading.SynchronizedMethods;

/**
 * Created by root on 22.11.15.
 */
public class SyncThread extends Thread {

    private Resource rs;
    public SyncThread(String name, Resource rs) {
        super(name);
        this.rs = rs;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            rs.writing(getName(), i);
        }
    }

}
