package com.gojava6.Multithreading;

/**
 * Created by root on 22.11.15.
 */
public class WalkRunnable implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            System.out.println("walking.");
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
