package com.vladik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladyslavmelnyk on 01.03.16.
 */
public class Reader {

    protected String readUserNumbersLine() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numbersLine = null;
        try {
            numbersLine = reader.readLine();
        } catch (IOException e) {
            numbersLine = "-1";
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Couldn't close the reader");
            }
        }
        return numbersLine;
    }

    protected List<Integer> parseUserNumbersLine(String[] pieces) {
        List<Integer> numbersLine = new ArrayList<Integer>();
        for (int i = 0; i < pieces.length; i++) {
            if (pieces[i].isEmpty()) {
                continue;
            }
            try {
                numbersLine.add(Integer.parseInt(pieces[i]));
            } catch (NumberFormatException e) {
                System.out.println("You can enter only numbers. \""
                        + pieces[i] + "\" is not a number. ");
            }
        }
        return numbersLine;
    }

}

