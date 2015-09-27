package io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by oktopus on 21.09.15.
 */
public class InputCase {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = null;
        try {

            stream = new FileInputStream("sometext.txt");
            int b;
            while ((b = stream.read() ) != -1) {
                System.out.println((char)b);
            }
        } finally {
            stream.close();
        }
    }
}
