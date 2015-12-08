package com.gojava6.Multithreading;

/**
 * Created by root on 22.11.15.
 */
public class WalkTalk {

    public static void main(String[] args) {
        TalkThread talkThread = new TalkThread();
        Thread walkThread = new Thread(new WalkRunnable());
        Thread daemon = new Thread(new WalkRunnable());
        daemon.setDaemon(true);

        talkThread.start();
        walkThread.start();
        daemon.start();
    }
}
