package com.goit.gojava3.hw1;

import java.util.Scanner;

public class WorldsAnagram {

    public static void main(String[] args) {

        System.out.flush();
        System.out.println("Input string");

        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        sc.close();

        StringBuilder builderReverse = new StringBuilder();
        StringBuilder builderWordForReverse = new StringBuilder();

        char  localSymbolInWord;
        
        for (int i = 0; i < inputLine.length(); i++) {
            localSymbolInWord = inputLine.charAt(i);;
            if (localSymbolInWord == ' ') {
                if (builderWordForReverse.length() > 0) {
                    builderReverse.append(builderWordForReverse.reverse());
                    builderWordForReverse.setLength(0);
                }    
                builderReverse.append(" ");
            } else {
                builderWordForReverse.append(localSymbolInWord);
            }
        }
        builderReverse.append(builderWordForReverse.reverse());
        System.out.println("result: " + builderReverse.toString());
    }

}
