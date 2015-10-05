package com.gojava6.io;

import java.io.*;

/**
 * Created by sergiigetman on 9/21/15.
 */
public class InputCase {
    public static void main(String[] args) throws IOException {
        /*BufferedReader stream = null;
        try {
            *//*stream = new FileInputStream("sometext.txt");*//*
            *//*stream = new FileReader("sometext.txt");*//*
            stream = new BufferedReader(new FileReader("sometext.txt"));
            String b;
            while ( (b = stream.readLine() )!= null) {
                System.out.println(b);
            }
        } finally {
            stream.close();
        }
*/
        String text = "They burned down the gambling house\n" +
                "It died with an awful sound\n" +
                "Funky Claude was running in and out\n" +
                "Pulling kids out the ground\n" +
                "When it all was over\n" +
                "We had to find another place\n" +
                "But Swiss time was running out\n" +
                "It seemed that we would lose the race\n" +
                "Smoke on the water, fire in the sky";
        String[] song = {"They burned down the gambling house\n" ,
                "It died with an awful sound\n" ,
                "Funky Claude was running in and out\n" ,
                "Pulling kids out the ground\n" ,
                "When it all was over\n" ,
                "We had to find another place\n" ,
                "But Swiss time was running out\n" ,
                "It seemed that we would lose the race\n" ,
                "Smoke on the water, fire in the sky"};
        PrintWriter fileOutputStream = null;
        try {
            /*fileOutputStream = new FileOutputStream("sometext.txt");*/
            fileOutputStream = new PrintWriter(new FileWriter("sometext.txt"));
            for (String s : song) {
                fileOutputStream.print(s);
            }
        } finally {
            fileOutputStream.close();
        }


    }
}
