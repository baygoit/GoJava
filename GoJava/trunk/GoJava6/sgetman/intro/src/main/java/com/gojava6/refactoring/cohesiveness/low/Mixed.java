package com.gojava6.refactoring.cohesiveness.low;

import java.io.*;

/**
 * Created by sergiigetman on 9/30/15.
 */
public class Mixed {

    public int sum(int a, int b) {
        return a + b;
    }

    public void readFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String s;
        while ( (s = br.readLine()) != null) {
            //TODO;
        }

    }
}
