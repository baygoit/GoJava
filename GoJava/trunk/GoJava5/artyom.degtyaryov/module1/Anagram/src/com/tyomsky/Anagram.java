package com.tyomsky;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {

    static BufferedReader consoleReader;
    public static void main(String[] args) {
        System.out.println("Enter input string: ");
        consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = getArrayOfStringsFromConsole();
        String[] reversedInput = getArrayWithReversedValues(input);

//        System.out.println(String.join(" ", reversedInput)); //  Java 1.8
        for(String s: reversedInput){
        	System.out.print(s +" ");
        }
    }

    public static String[] getArrayOfStringsFromConsole(){
        String[] result;
        try {
            result = consoleReader.readLine().split(" ");
        }catch (IOException e){
            System.err.println("Invalid input! Try again");
            return null;
        }
        return result;
    }

    public static String[] getArrayWithReversedValues(String[] input){
        String[] result = new String[input.length];
        for(int i = 0; i < result.length; i++){
            result[i] = new StringBuilder(input[i]).reverse().toString();
        }
        return result;
    }


}
