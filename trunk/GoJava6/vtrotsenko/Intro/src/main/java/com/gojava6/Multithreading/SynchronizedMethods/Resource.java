package com.gojava6.Multithreading.SynchronizedMethods;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by root on 22.11.15.
 */
public class Resource {

    private FileWriter fileWriter;
    public Resource(String file) throws IOException {
        fileWriter = new FileWriter(file, true);
    }

    public synchronized void writing(String str, int i) {
        try {
            fileWriter.append(str + i);
            System.out.println(str + i);

            Thread.sleep((long) Math.random() * 50);

            fileWriter.append("->" + i + " ");
            System.out.println("->" + i + " ");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
