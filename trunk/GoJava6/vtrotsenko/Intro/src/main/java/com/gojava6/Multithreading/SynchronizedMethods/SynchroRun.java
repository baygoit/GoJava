package com.gojava6.Multithreading.SynchronizedMethods;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by root on 22.11.15.
 */
public class SynchroRun {

    public static void main(String[] args) {
        Resource rs = null;

        try {
            rs = new Resource("synchro.txt");
            SyncThread t1 = new SyncThread("First", rs);
            SyncThread t2 = new SyncThread("Second", rs);

            t1.start();
            t2.start();

            t1.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            rs.close();
        }
    }

}
