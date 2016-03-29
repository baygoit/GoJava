package com.vladik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Reader {

    private String readUserInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String strLines = null;
        try {
            strLines = reader.readLine();
        } catch (IOException e) {
            strLines = "-1";
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Couldn't close the reader");
            }
        }
        return strLines;
    }

    public List<String> getListOfStr() {
        List<String> listOfInputs = Arrays.asList(readUserInput().split(" "));
        return listOfInputs;
    }


}

